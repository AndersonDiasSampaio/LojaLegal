package com.cdb.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cdb.model.Product;
import com.cdb.repository.ProdutoRepository;

@Controller
public class EstoqueDate  {

	@Autowired
	ProdutoRepository produtoRepository;

	public EstoqueDate() {
		// TODO Auto-generated constructor stub
	}

	
	
	public void save(Object obj) {

		this.produtoRepository.save((Product) obj);

		
	}

	public Product productBySKU(String Sku) {
		Product p = this.produtoRepository.findBySku(Sku);
		return p;
	

	}

	
	public void update(Object obj) {
	this.produtoRepository.save((Product)obj);

	}

	
	public boolean delete(Object sku) {

		Product p = this.produtoRepository.findBySku((String) sku);
		if (p == null) {
			return false;
		} else {
			this.produtoRepository.delete(p);
			return true;
		}
	}

	public List<Product> listStock() {
		List<Product> p= this.produtoRepository.findAll();
		return p;
	}
	

}
