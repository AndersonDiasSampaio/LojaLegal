package com.cdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cdb.model.Product;
import com.cdb.repository.ProdutoRepository;
import com.cdb.service.EstoqueService;
import com.cdb.service.VendasService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	@Autowired(required = true)
	EstoqueService stockService;

	
	public ProductController() {
		// TODO Auto-generated constructor stub
	}


	@RequestMapping(method = RequestMethod.GET, value = "/produto")
	public List<Product> getProduto() {
	
		return stockService.listItems();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/produto")
	public void postProduto(@RequestBody Product produto) {
		
		//Produto n = new Produto("SIMazuFEMPEQ", 20, 20d, "teste");
		//produtoRepository.save(n);
		stockService.registProduct(produto);
		//return estoqueService.listItems();
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/delproduto/{sku}")
	public void deleteProduto(@PathVariable  String sku) {
		
		stockService.excluirProduto(sku);
		
	}
}
