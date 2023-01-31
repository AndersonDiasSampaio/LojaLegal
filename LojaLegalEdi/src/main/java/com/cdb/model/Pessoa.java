package com.cdb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.relational.core.mapping.Column;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column("id")
	private long id;
	@Column
	private String nome;
	@Column
	private String cpf;
	@Column
	private String endereco;

	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Venda> Vendas = new ArrayList();

	public Pessoa(String nome, String cpf, String endereco) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
	}

	public long getId() {
		return id;
	}

	public Pessoa() {
		this.nome = "Nome nao informado";
		this.cpf = "CPF nao informado";
		this.endereco = "endereco nao informado";
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco + "]";
	}

	public List<Venda> getVendas() {
		return Vendas;
	}

}
