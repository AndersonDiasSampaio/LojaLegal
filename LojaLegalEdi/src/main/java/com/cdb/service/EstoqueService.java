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
		return stock.listStock();

	}

	public void updateProduct(Product produto) {
		stock.update(produto);
	}

	// Procurar produto por sku
	public Product searchProductbySku(String sku) {

		return stock.productBySKU(sku);
	}

	public Product searchProductInList(int interator) {

		return (Product) listItems().get(interator);
	}

	// registrar o produto
	public boolean registProduct(Product produto) {
		boolean status= false;
		Product produtoSetado = new Product(produto.getSku(), produto.getQuantity(), produto.getValue(),
				produto.getDescription());
		if ((produtoSetado.getColor() == null) || (produtoSetado.getDepartment() == null)
				|| (produtoSetado.getCategory() == null) || (produtoSetado.getSize() == null)) {
			System.out.print(produtoSetado);
			return status;

		} else {
			if ((searchProductbySku(produto.getSku()) == null)) {
				stock.save(produtoSetado);
				// fazer uns ifs aqui pra verificar se o produto é nulo, colocar um bloco
				// trycatch quando for pegar um produto com sku e verificar se algum é nulo na
				// classe produto.
				status= true;
				return status;
			} else {
				produtoSetado.setQuantity(
						produtoSetado.getQuantity() + searchProductbySku(produto.getSku()).getQuantity());
				produtoSetado.setId(searchProductbySku(produto.getSku()).getId());
				stock.update(produtoSetado);
				status= true;
				return status;
			}
		}

	}

//excluir o produto
	//mudei pra boolean era string
	public boolean deleteProduct(String sku) {
//quem usar isso vai usar hhtp ok ou http not found
		
		return this.stock.delete(sku);

	}
}
