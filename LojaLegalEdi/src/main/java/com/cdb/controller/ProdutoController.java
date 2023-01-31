package com.cdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cdb.model.Produto;
import com.cdb.repository.ProdutoRepository;
import com.cdb.service.EstoqueService;
import com.cdb.service.VendasService;

@RestController
@RequestMapping(value = "/product")
public class ProdutoController {
	@Autowired(required = true)
	EstoqueService estoqueService;

	
	public ProdutoController() {
		// TODO Auto-generated constructor stub
	}


	@RequestMapping(method = RequestMethod.GET, value = "/produto")
	public List<Produto> getProduto() {
	
		return estoqueService.listItems();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/produto")
	public void postProduto(@RequestBody Produto produto) {
		
		//Produto n = new Produto("SIMazuFEMPEQ", 20, 20d, "teste");
		//produtoRepository.save(n);
		estoqueService.registrarProduto(produto);
		//return estoqueService.listItems();
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/delproduto/{sku}")
	public void deleteProduto(@PathVariable  String sku) {
		
		estoqueService.excluirProduto(sku);
		
	}
}
