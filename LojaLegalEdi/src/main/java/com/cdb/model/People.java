package com.cdb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "pessoa")

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class People implements Serializable {
	private static final long serialVersionUID = 1L;
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	@Column
	private String nome;
	@Column
	private String cpf;
	@Column
	private String address;

	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Sell> Vendas = new ArrayList();

	public People(String nome, String cpf, String endereco) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.address = endereco;
	}

	public long getId() {
		return id;
	}

	public People() {
		this.nome = "Nome nao informado";
		this.cpf = "CPF nao informado";
		this.address = "endereco nao informado";
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String endereco) {
		this.address = endereco;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", endereco=" + address + "]";
	}

	public List<Sell> getVendas() {
		return Vendas;
	}

}
