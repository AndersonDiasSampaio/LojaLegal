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
	
	public void updatePrice(double price, String sku) {
		this.produtoRepository.updateProdutoPriceBySku(price, sku);
	}
	public void updateDescription(String Description, String sku) {
		this.produtoRepository.updateProdutoSku(Description, sku);
	}
}
