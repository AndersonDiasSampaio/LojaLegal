package com.cdb.data.memory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cdb.model.ProdutoComprado;
import com.cdb.model.Venda;
import com.cdb.repository.VendasRepository;
@Controller
public class SellData {
	@Autowired
	VendasRepository vendasRepository;
	private List<Venda> sellData = new ArrayList();
	
	private Venda sell = new Venda();

	public SellData() {
		// TODO Auto-generated constructor stub

	}

	public Venda getSell() {
		return sell;
	}

	public boolean delete(ProdutoComprado produto) {
		ProdutoComprado p = new ProdutoComprado(produto.getSku(), produto.getQuantidade(), produto.getValor(), produto.getDescricao());

		return this.sell.deleteProduto(p);

	}

	public void update(Object obj) {
		boolean b = false;
		ProdutoComprado pr = (ProdutoComprado) obj;
		for (Object element : sell.getProdutos()) {
			ProdutoComprado product = (ProdutoComprado) element;
			System.out.println(product.getSku());
			if (pr.getSku().equals(product.getSku())) {// mexi no pr.gerSku era == não equals
				product.setCategoria(pr.getCategoria());
				product.setCor(pr.getCor());
				product.setDepartamento(pr.getDepartamento());
				product.setDescricao(pr.getDescricao());
				product.setValor(pr.getValor());
				product.setQuantidade(pr.getQuantidade() + product.getQuantidade());
				product.setTamanho(pr.getTamanho());
				b = true;
			}
		}
		if (b == false) {
			save(obj);
		}
	}

	public List<Venda> listItens() {
		return vendasRepository.findAll(); //mechi aqui
	}

	public Object getItem(Object obj) {

		return this.sell.getProductInTheList((int) obj);
		// this.sell.getProductList().get((int) obj);
	}

	public void save(Object obj) {
		ProdutoComprado product = (ProdutoComprado) obj;
		// TODO Auto-generated method stub
		this.sell.setProdutos(product);

	}

	public void refrestcard() {
		this.sell = new Venda();
	}

	

	public void save(double price, String CPF, String PaymentMethod, String valueBancaryData, String name,
			String endereco) {

		this.sell.setTipoDePagamento(PaymentMethod, valueBancaryData);
		this.sell.setDateTime();
		this.sell.setPessoa(CPF, endereco, name);
		
		this.sell.setPrice(price);
		vendasRepository.save(this.sell);
		sellData.add(this.sell);
		

	}



	public List<ProdutoComprado> listProduct() {

		return this.sell.getProdutos();
	}

	public void  deleteProdutoIncard(ProdutoComprado produto) {
		 this.sell.deleteProduto(produto);
	}

	@Override
	public String toString() {
		return "SellData [sellData=" + sellData + ", sell=" + sell + "]";
	}

}
