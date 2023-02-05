package com.cdb.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "venda")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Sell implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonIgnore
	private long id;
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;
	@Column
	private String dateTime;
	@Column
	private Double total;

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "vendas_produtos", joinColumns = @JoinColumn(name = "produtocomprado_id"))
	private List<PurchasedProduct> products = new ArrayList();
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "pagamento_id")
	Pagamento tipoDePagamento;

	

	public Sell() {
		// TODO Auto-generated constructor stub
		this.tipoDePagamento = new Pagamento();
		this.pessoa = new Pessoa();
	}

	public Double getTotal() {
		return total;
	}

	public PurchasedProduct getProductInTheList(int x) {
		return products.get(x);
	}

	public void setPrice(Double price) {
		this.total = price;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime() {
		LocalDateTime dateTime2 = LocalDateTime.now();
		String a = dateTime2.toString();
		dateTime = a.substring(0, 10);
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(String cpf, String endereco, String nome) {
		this.pessoa = new Pessoa();
		this.pessoa.setCpf(cpf);
		this.pessoa.setEndereco(endereco);
		this.pessoa.setNome(nome);

	}

	public Pagamento getTipoDePagamento() {
		return tipoDePagamento;
	}

	public void setTipoDePagamento(String tipoDePagamento, String value) {
		this.tipoDePagamento = new Pagamento();
		this.tipoDePagamento.setCodigo(tipoDePagamento);
		this.tipoDePagamento.setTipo(value);

	}

	public List<PurchasedProduct> getProdutos() {
		return products;
	}

	public void setProdutos(PurchasedProduct vender) {
		this.products.add(vender);
	}

	public boolean deleteProduto(PurchasedProduct produdo) {
		return this.products.remove(produdo);
	}

	@Override
	public String toString() {
		return "Venda [pessoa=" + pessoa + ", total=" + total + ", tipoDePagamento=" + tipoDePagamento + ", dateTime="
				+ dateTime + ", price=" + total + ", vender=" + products + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sell other = (Sell) obj;
		return id == other.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
