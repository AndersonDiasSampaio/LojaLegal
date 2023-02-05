package com.cdb.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdb.data.EstoqueDate;
import com.cdb.model.Product;
import com.cdb.repository.ProdutoRepository;

@Service
public class EstoqueService {

	@Autowired
	private EstoqueDate stock;

	public List<Product> listItems() {
		return stock.listEstoque();

	}

	public void updateProduto(Product produto) {
		stock.update(produto);
	}

	// Procurar produto por sku
	public Product procurarProduto(String sku) {

		for (int x = 0; x < listItems().size(); x++) {
			Product produto = (Product) listItems().get(x);
			if (sku.equals(produto.getSku())) {
				return produto;
			}

		}
		return null;
	}

	public Product procurarProduto(int valor) {

		return (Product) listItems().get(valor);
	}

	// registrar o produto
	public void registrarProduto(Product produto) {

		Product produtoSetado = new Product(produto.getSku(), produto.getQuantity(), produto.getValue(),
				produto.getDescription());
		if (stock.produrarProduto(produto.getSku()) == null) {
			stock.save(produtoSetado);
			// fazer uns ifs aqui pra verificar se o produto é nulo, colocar um bloco
			// trycatch quando for pegar um produto com sku e verificar se algum é nulo na classe produto.
		} else {
			produtoSetado.setQuantity(
					produtoSetado.getQuantity() + stock.produrarProduto(produto.getSku()).getQuantity());
			produtoSetado.setId(stock.produrarProduto(produto.getSku()).getId());
			stock.update(produtoSetado);
			;
		}

	}

//excluir o produto
	public String excluirProduto(String sku) {

		this.stock.delete(sku);
		return null;

	}
}
