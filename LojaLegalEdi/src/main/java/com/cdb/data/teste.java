package com.cdb.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cdb.model.Product;
import com.cdb.repository.ProdutoRepository;

@Controller
public class teste {
/*
	@Autowired
	ProdutoRepository produtoRepository;

	public teste() {
	}

	@Autowired
	List<Object> estoqueDate = new ArrayList<Object>();

	@Override
	public boolean save(Object obj) {

		this.produtoRepository.save((Produto) obj);

	
		return false;
	}

	public Produto produrarProduto(String Sku) {
		Produto p = this.produtoRepository.findBySku(Sku);
		return p;
	

	}

	@Override
	public void update(Object obj) {
	this.produtoRepository.save((Produto)obj);

	}

	@Override
	public boolean delete(Object sku) {

		Produto p = this.produtoRepository.findBySku((String) sku);
		if (p == null) {
			return false;
		} else {
			this.produtoRepository.delete(p);
			return true;
		}
	}



	@Override
	public List<Object> listItems() {
		List<Produto> p= this.produtoRepository.findAll();
		return (List<Object>) estoqueDate;
	}
	public List<Produto> listEstoque() {
		List<Produto> p= this.produtoRepository.findAll();
		return p;
	}
	
*/
}
