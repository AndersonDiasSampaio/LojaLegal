package com.cdb.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cdb.model.PurchasedProduct;
import com.cdb.model.Sell;
import com.cdb.repository.VendasRepository;
@Controller
public class SellData {
	@Autowired
	VendasRepository vendasRepository;
	
	private Sell sell;

	public SellData() {
		// TODO Auto-generated constructor stub
		this.sell = new Sell();

	}

	public Sell getSell() {
		return sell;
	}

	public boolean delete(PurchasedProduct product) {
		PurchasedProduct p = new PurchasedProduct(product.getSku(), product.getQuantity(), product.getValue(), product.getDescription());

		return this.sell.deleteProduto(p);

	}

	public void update(Object obj) {
		boolean b = false;
		PurchasedProduct pr = (PurchasedProduct) obj;
		for (Object element : sell.getProdutos()) {
			PurchasedProduct product = (PurchasedProduct) element;
			System.out.println(product.getSku());
			if (pr.getSku().equals(product.getSku())) {// mexi no pr.gerSku era == não equals
				product.setCategory(pr.getCategory());
				product.setColor(pr.getColor());
				product.setDepartment(pr.getDepartment());
				product.setDescription(pr.getDescription());
				product.setValue(pr.getValue());
				product.setQuantity(pr.getQuantity() + product.getQuantity());
				product.setSize(pr.getSize());
				b = true;
			}
		}
		if (b == false) {
			save(obj);
		}
	}

	public List<Sell> listItens() {
		return vendasRepository.findAll(); //mechi aqui
	}

	public Object getItem(Object obj) {

		return this.sell.getProductInTheList((int) obj);
		// this.sell.getProductList().get((int) obj);
	}

	public void save(Object obj) {
		PurchasedProduct product = (PurchasedProduct) obj;
		// TODO Auto-generated method stub
		this.sell.setProdutos(product);

	}

	public void refrestcard() {
		this.sell = new Sell();
	}

	

	public void save(double price, String CPF, String PaymentMethod, String valueBancaryData, String name,
			String endereco) {

		this.sell.setTipoDePagamento(PaymentMethod, valueBancaryData);
		this.sell.setDateTime();
		this.sell.setPessoa(CPF, endereco, name);
		
		this.sell.setPrice(price);
		vendasRepository.save(this.sell);
		

	}



	public List<PurchasedProduct> listProduct() {

		return this.sell.getProdutos();
	}

	public void  deleteProdutoIncard(PurchasedProduct produto) {
		 this.sell.deleteProduto(produto);
	}

	@Override
	public String toString() {
		return "SellData [ sell=" + sell + "]";
	}

}
