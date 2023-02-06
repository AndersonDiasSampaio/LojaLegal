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

	public PurchasedProduct searchProduct(String sku) {

		for (int x = 0; x < productIncardToSell().size(); x++) {
			PurchasedProduct produto = (PurchasedProduct) productIncardToSell().get(x);
			if (sku.equals(produto.getSku())) {
				return produto;
			}

		}
		return null;
	}
//VAI VIRAR BOLEANO
	public boolean deleteProduct(String sku) {
		boolean  state=false;
		PurchasedProduct produto = searchProduct(sku);
		if (produto != null) {
			sellData.deleteProdutoIncard(produto);
			state=true;
			return state;
			
		} else {
			return state;
		}

	}

	public boolean addProductCard(PurchasedProduct product, int quantity) {
		PurchasedProduct p = new PurchasedProduct(product.getSku(), product.getQuantity(), product.getValue(), product.getDescription());
		boolean addcard = false;
		if ((p.getSku() == null)||(p.getColor() == null) || (p.getDepartment() == null)
				|| (p.getCategory() == null) || (p.getSize() == null)) {
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
					if ((p8.getSku().equals(Stock.searchProductInList(x).getSku()))
							&& (p8.getQuantity() <= Stock.searchProductInList(x).getQuantity())) {
						
						negativeCount--;

					}

				}

			}

			if (negativeCount == 0) {
				for (int x = 0; x < Stock.listItems().size(); x++) {
					for (int y = 0; y < productIncardToSell().size(); y++) {
						PurchasedProduct p8 = (PurchasedProduct) getSellData().getItem(y);
						if (p8.getSku().equals(Stock.searchProductInList(x).getSku())) {
							p8.setCategory(Stock.searchProductInList(x).getCategory());
							p8.setDescription(Stock.searchProductInList(x).getDescription());
							p8.setColor(Stock.searchProductInList(x).getColor());
							p8.setSize(Stock.searchProductInList(x).getSize());
							p8.setDepartment(Stock.searchProductInList(x).getDepartment());
							p8.setValue(Stock.searchProductInList(x).getValue());
							Stock.searchProductInList(x)
									.setQuantity(Stock.searchProductInList(x).getQuantity() - p8.getQuantity());
							Stock.updateProduct(Stock.searchProductInList(x));
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
