package com.cdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cdb.model.Pessoa;
import com.cdb.model.ProdutoComprado;
import com.cdb.repository.PessoaRepository;
import com.cdb.repository.VendasRepository;
import com.cdb.service.EstoqueService;
import com.cdb.service.VendasService;

@RestController
public class SellControler {
	@Autowired
	VendasService sellService;
	@Autowired
	VendasRepository sellRepository;
	@Autowired
	PessoaRepository peapleRepository;
	@Autowired
	EstoqueService productService;
	

	public SellControler() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(method = RequestMethod.POST, value = "/adprodutos")
	public boolean setProduto(@RequestBody ProdutoComprado produto) {

		return sellService.addProductCard(produto, produto.getQuantidade());
	}

	@RequestMapping(method = RequestMethod.GET, value = "/produtos")
	public ResponseEntity<Object> getProdutosInTheCar() {

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(sellService.getSellData().listProduct());
	}

	@RequestMapping(method = RequestMethod.POST, value = "/buyprodutos/{PaymentMethod}/{valueBancaryData}")
	public void buyProdutos1(@PathVariable String PaymentMethod, @PathVariable String valueBancaryData,
			@RequestBody Pessoa pessoa) { // Produto a = new
		// Produto("SIMazuMASPEQ", 5, 20d, "teste");

		sellService.sellStockTestAndBuy(pessoa.getCpf(), PaymentMethod, valueBancaryData, pessoa.getNome(),
				pessoa.getEndereco());
		System.out.println(sellService.getSellData().getSell());
/*
		vendasRepository.save(vendasService.getSellData().getSell());*/
		sellService.cancel();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/produtoshist")
	public ResponseEntity<Object> getHistoryofSell() {

		return ResponseEntity.status(HttpStatus.ACCEPTED).body( sellRepository.findAll());
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/delprodutocard")
	public String deleteProduto(@RequestBody String Sku) {

		return sellService.excluirProduto(Sku);

	}

	/*
	 * @RequestMapping(method = RequestMethod.POST, value = "/adprodutos") public
	 * boolean setProduto(@RequestBody Produto produto) {
	 * 
	 * return vendasService.addProductCard(produto, produto.getQuantidade()); }
	 * 
	 * @RequestMapping(method = RequestMethod.GET, value = "/produtos") public
	 * ResponseEntity<Object> getProdutosInTheCar() {
	 * 
	 * return
	 * ResponseEntity.status(HttpStatus.ACCEPTED).body(vendasService.getSellData().
	 * listProduct()); }
	 * 
	 * @RequestMapping(method = RequestMethod.POST, value =
	 * "/buyprodutos/{PaymentMethod}/{valueBancaryData}") public void
	 * buyProdutos1(@PathVariable String PaymentMethod, @PathVariable String
	 * valueBancaryData,
	 * 
	 * @RequestBody Pessoa pessoa) {
	 * 
	 * // Produto a = new Produto("SIMazuMASPEQ", 5, 20d, "teste");
	 * 
	 * vendasService.sellStockTestAndBuy(pessoa.getCpf(), PaymentMethod,
	 * valueBancaryData, pessoa.getNome(), pessoa.getEndereco());
	 * 
	 * vendasRepository.save(vendasService.getSellData().getSell());
	 * vendasService.cancel();
	 * 
	 * 
	 * }
	 * 
	 * @RequestMapping(method = RequestMethod.GET, value = "/produtoshist") public
	 * List<Venda> getHistoryofSell() { List<Venda> v = vendasRepository.findAll();
	 * 
	 * return v; }
	 * 
	 * 
	 * @RequestMapping(method = RequestMethod.DELETE, value = "/delprodutocard")
	 * public String deleteProduto(@RequestBody String Sku) {
	 * vendasRepository.deleteById((long) 6); // pessoaRepository.deleteById((long)
	 * 7);
	 * 
	 * return vendasService.excluirProduto(Sku);
	 * 
	 * }
	 */

}
