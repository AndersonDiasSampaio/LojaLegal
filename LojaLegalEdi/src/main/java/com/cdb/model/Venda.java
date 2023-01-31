package com.cdb.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.relational.core.mapping.Column;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
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


/*
 * CRIAR ENUMS PRA OS TIPOS DE PAGAMENTO
 * DEPOIS SETAR AS ENUMS
 *  
*/
@Entity
@Table(name = "venda")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Venda implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column("id")
    @JsonIgnore
	private long id;
	@ManyToOne(cascade=CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "pessoa_id" )
	private Pessoa pessoa = new Pessoa();
	@Column
	private String dateTime;
	@Column
	private Double total;
	
	
	@ManyToMany(cascade=CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "vendas_produtos", joinColumns = @JoinColumn(name = "produtocomprado_id"))
	private List<ProdutoComprado> produtos = new ArrayList();
	@ManyToOne(cascade=CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "pagamento_id" )
	Pagamento tipoDePagamento=new Pagamento();

	public Venda(String nome, String cpf, String endereco) {
		// super(nome, cpf, endereco);
		this.pessoa.setNome(nome);
		this.pessoa.setCpf(cpf);
		this.pessoa.setEndereco(endereco);

	}

	public Venda() {
		// TODO Auto-generated constructor stub
		pessoa = new Pessoa();
	}

	public Double getTotal() {
		return total;
	}

	public ProdutoComprado getProductInTheList(int x) {
		return produtos.get(x);
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
		this.pessoa.setCpf(cpf);
		this.pessoa.setEndereco(endereco);
		this.pessoa.setNome(nome);

	}
	 
	public Pagamento getTipoDePagamento() {
		return tipoDePagamento;
	}

	public void setTipoDePagamento(String tipoDePagamento, String value) {
		 this.tipoDePagamento.setCodigo(tipoDePagamento);
		 this.tipoDePagamento.setTipo(value);
		/*if (tipoDePagamento.equals("PIX")) {
			Pix a = new Pix();
			a.setKey(value);
			this.tipoDePagamento = a;

		} else if (tipoDePagamento.equals("DINHEIRO")) {
			Dinheiro a = new Dinheiro();
			a.TipoDPagemento(value);
			this.tipoDePagamento = a;

		} else if (tipoDePagamento.equals("CartaoDeCredito")) {
			CartaoDeCredito a = new CartaoDeCredito();
			a.TipoDPagemento(value);
			this.tipoDePagamento = a;
		} else if (tipoDePagamento.equals("CartaoDeDebito")) {
			CartaoDeDebito a = new CartaoDeDebito();
			a.TipoDPagemento(value);
			this.tipoDePagamento = a;
		}*/
	}

	public List<ProdutoComprado> getProdutos() {
		return produtos;
	}

	public void setProdutos(ProdutoComprado vender) {
		this.produtos.add(vender);
	}

	public boolean deleteProduto(ProdutoComprado produdo) {
		return this.produtos.remove(produdo);
	}

	@Override
	public String toString() {
		return "Venda [pessoa=" + pessoa + ", total=" + total + ", tipoDePagamento=" + tipoDePagamento + ", dateTime="
				+ dateTime + ", price=" + total + ", vender=" + produtos + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		return id == other.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
