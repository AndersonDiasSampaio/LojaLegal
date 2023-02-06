package com.cdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cdb.model.Product;
import com.cdb.service.StockService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	@Autowired(required = true)
	StockService stockService;

	public ProductController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(method = RequestMethod.GET, value = "/produto")
	public List<Product> getProduto() {

		return stockService.listItems();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/produto")
	public ResponseEntity<Object> postProduto(@RequestBody Product produto) {
		boolean state = stockService.registProduct(produto);
		if (state == false) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("não foi possível adicionar o produto no carrinho verifique o SKU");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body("produto adicionado com sucesso");
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/delproduto/{sku}")
	public ResponseEntity<Object> deleteProduto(@PathVariable String sku) {
		boolean state = stockService.deleteProduct(sku);
		if (state == false) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("não foi possível deletar o produto no carrinho verifique o SKU");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body("produto excluído com sucesso");
		}

	}
	@Transactional
	@RequestMapping(method = RequestMethod.PATCH, value = "/produtodescriptioneedi")
	public ResponseEntity<Object> patchProdutoDescription(@RequestBody Product product) {
		if (product.getDescription() != null) {
			stockService.updateDescription(product.getDescription(), product.getSku());
			return ResponseEntity.status(HttpStatus.OK).body("Descrição do produto atualizado com sucesso");
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("não foi possível editar o produto verifique os dados enviados");
		}
	}
	@Transactional
	@RequestMapping(method = RequestMethod.PATCH, value = "/produtovaloredit")
	public ResponseEntity<Object> patchProdutovalue(@RequestBody Product product) {
		if (product.getValue() != 0) {
			stockService.updatePrice(product.getValue(), product.getSku());
			return ResponseEntity.status(HttpStatus.OK).body("Valor do produto atualizado com sucesso");

		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("não foi possível editar o produto verifique os dados enviados");
		}
	}

}
