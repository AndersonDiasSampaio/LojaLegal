package com.cdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdb.data.SellData;
import com.cdb.model.Product;
import com.cdb.model.ProdutoComprado;
import com.cdb.model.Venda;

@Service
public class VendasService {
	
	@Autowired
	private EstoqueService Stock;
	@Autowired
	private SellData sellData;

	public VendasService() {
		// TODO Auto-generated constructor stub
	}

	public ProdutoComprado procurarProduto(String sku) {

		for (int x = 0; x < productIncardToSell().size(); x++) {
			ProdutoComprado produto = (ProdutoComprado) productIncardToSell().get(x);
			if (sku.equals(produto.getSku())) {
				return produto;
			}

		}
		return null;
	}

	public String excluirProduto(String sku) {
		ProdutoComprado produto = procurarProduto(sku);
		if (produto != null) {
			sellData.deleteProdutoIncard(produto);
			return "Excludio";
			
		} else {
			return "Inv�lido";
		}

	}

	public boolean addProductCard(ProdutoComprado product, int quantity) {
		ProdutoComprado p = new ProdutoComprado(product.getSku(), product.getQuantidade(), product.getValor(), product.getDescricao());
		boolean addcard = false;
		if (p.getSku() == null) {
			return addcard;
		} else {

			p.setQuantidade(quantity);
			Object p2 = p;
			sellData.update(p2);
			addcard = true;
			return addcard;
		}
	}

	public List<ProdutoComprado> productIncardToSell() {
		return sellData.listProduct();
	}

	public SellData getSellData() {
		return sellData;
	}

	public List<Venda> getSellDataList() {
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
					ProdutoComprado p8 = (ProdutoComprado) getSellData().getItem(y);
					if ((p8.getSku().equals(Stock.procurarProduto(x).getSku()))
							&& (p8.getQuantidade() <= Stock.procurarProduto(x).getQuantity())) {
						
						negativeCount--;

					}

				}

			}

			if (negativeCount == 0) {
				for (int x = 0; x < Stock.listItems().size(); x++) {
					for (int y = 0; y < productIncardToSell().size(); y++) {
						ProdutoComprado p8 = (ProdutoComprado) getSellData().getItem(y);
						if (p8.getSku().equals(Stock.procurarProduto(x).getSku())) {
							p8.setCategoria(Stock.procurarProduto(x).getCategory());
							p8.setDescricao(Stock.procurarProduto(x).getDescription());
							p8.setCor(Stock.procurarProduto(x).getCorlor());
							p8.setTamanho(Stock.procurarProduto(x).getSize());
							p8.setDepartamento(Stock.procurarProduto(x).getDepartment());
							p8.setValor(Stock.procurarProduto(x).getValue());
							Stock.procurarProduto(x)
									.setQuantity(Stock.procurarProduto(x).getQuantity() - p8.getQuantidade());
							Stock.updateProduto(Stock.procurarProduto(x));
							priceToBil = (p8.getValor() * p8.getQuantidade()) + priceToBil;

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
