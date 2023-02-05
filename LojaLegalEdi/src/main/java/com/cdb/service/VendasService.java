package com.cdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdb.data.SellData;
import com.cdb.model.Product;
import com.cdb.model.PurchasedProduct;
import com.cdb.model.Sell;

@Service
public class VendasService {
	
	@Autowired
	private EstoqueService Stock;
	@Autowired
	private SellData sellData;

	public VendasService() {
		// TODO Auto-generated constructor stub
	}

	public PurchasedProduct procurarProduto(String sku) {

		for (int x = 0; x < productIncardToSell().size(); x++) {
			PurchasedProduct produto = (PurchasedProduct) productIncardToSell().get(x);
			if (sku.equals(produto.getSku())) {
				return produto;
			}

		}
		return null;
	}

	public String excluirProduto(String sku) {
		PurchasedProduct produto = procurarProduto(sku);
		if (produto != null) {
			sellData.deleteProdutoIncard(produto);
			return "Excludio";
			
		} else {
			return "Inv�lido";
		}

	}

	public boolean addProductCard(PurchasedProduct product, int quantity) {
		PurchasedProduct p = new PurchasedProduct(product.getSku(), product.getQuantity(), product.getValue(), product.getDescription());
		boolean addcard = false;
		if (p.getSku() == null) {
			return addcard;
		} else {

			p.setQuantity(quantity);
			Object p2 = p;
			sellData.update(p2);
			addcard = true;
			return addcard;
		}
	}

	public List<PurchasedProduct> productIncardToSell() {
		return sellData.listProduct();
	}

	public SellData getSellData() {
		return sellData;
	}

	public List<Sell> getSellDataList() {
		return sellData.listItens();
	}

	public void cancel() {
		sellData.refrestcard();

	}

	

	public boolean sellStockTestAndBuy(String CPF, String PaymentMethod, String valueBancaryData, String name,
			String endereco) {
		boolean pedidoRealizado = false;
		double priceToBil = 0d;
		Object obj;
		int negativeCount = productIncardToSell().size();
	
		if (sellData.listProduct().size() > 0) {
			for (int x = 0; x < Stock.listItems().size(); x++) {
				
				for (int y = 0; y < productIncardToSell().size(); y++) {
					PurchasedProduct p8 = (PurchasedProduct) getSellData().getItem(y);
					if ((p8.getSku().equals(Stock.procurarProduto(x).getSku()))
							&& (p8.getQuantity() <= Stock.procurarProduto(x).getQuantity())) {
						
						negativeCount--;

					}

				}

			}

			if (negativeCount == 0) {
				for (int x = 0; x < Stock.listItems().size(); x++) {
					for (int y = 0; y < productIncardToSell().size(); y++) {
						PurchasedProduct p8 = (PurchasedProduct) getSellData().getItem(y);
						if (p8.getSku().equals(Stock.procurarProduto(x).getSku())) {
							p8.setCategory(Stock.procurarProduto(x).getCategory());
							p8.setDescription(Stock.procurarProduto(x).getDescription());
							p8.setColor(Stock.procurarProduto(x).getColor());
							p8.setSize(Stock.procurarProduto(x).getSize());
							p8.setDepartment(Stock.procurarProduto(x).getDepartment());
							p8.setValue(Stock.procurarProduto(x).getValue());
							Stock.procurarProduto(x)
									.setQuantity(Stock.procurarProduto(x).getQuantity() - p8.getQuantity());
							Stock.updateProduto(Stock.procurarProduto(x));
							priceToBil = (p8.getValue() * p8.getQuantity()) + priceToBil;

						}

					}

				}
			

				sellData.save(priceToBil, CPF, PaymentMethod, valueBancaryData, name, endereco);
				pedidoRealizado = true;
				return pedidoRealizado;
			} else {
				sellData.refrestcard();

				return pedidoRealizado;
			}
		} else {
			return pedidoRealizado;
		}

	}
	}
