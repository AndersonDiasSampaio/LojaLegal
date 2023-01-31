package com.cdb.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdb.data.EstoqueDate;
import com.cdb.model.Produto;
import com.cdb.repository.ProdutoRepository;

@Service
public class EstoqueService {

	@Autowired
	private EstoqueDate estoque;
	
	public List<Produto> listItems() {
		return estoque.listEstoque();

	}
	public void updateProduto(Produto produto) {
		estoque.update(produto);
	}
	
	// Procurar produto por sku
	public Produto procurarProduto(String sku) {

		for (int x = 0; x < listItems().size(); x++) {
			Produto produto = (Produto) listItems().get(x);
			if (sku.equals(produto.getSku())) {
				return produto;
			}

		}
		return null;
	}

	public Produto procurarProduto(int valor) {

		return (Produto)listItems().get(valor);
	}

	// registrar o produto
	public void registrarProduto(Produto produto) {
	
		Produto produtoSetado = new Produto(produto.getSku(), produto.getQuantidade(), produto.getValor(), produto.getDescricao());
		if (estoque.produrarProduto(produto.getSku()) == null) {
			estoque.save(produtoSetado);
			
		} else {
			produtoSetado.setQuantidade(produtoSetado.getQuantidade()+estoque.produrarProduto(produto.getSku()).getQuantidade());
			produtoSetado.setId(estoque.produrarProduto(produto.getSku()).getId());
			System.out.println(produtoSetado);
			estoque.update(produtoSetado);;
		}

	}



//excluir o produto
	public String excluirProduto(String sku) {
	
		this.estoque.delete(sku);
		return null;

	}
}
