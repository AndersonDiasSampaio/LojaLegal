package com.cdb.model;

import java.io.Serializable;

import com.cdb.Enum.CategoriaEnum;
import com.cdb.Enum.CorEnum;
import com.cdb.Enum.DepartamentoEnum;
import com.cdb.Enum.TamanhoEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "produto")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	@Column
	private String sku;
	@Column
	private int quantidade;
	@Column
	private double valor;
	@Column
	private String descricao;

	@Enumerated(EnumType.STRING)
	private DepartamentoEnum departamento;

	@Enumerated(EnumType.STRING)
	private CategoriaEnum categoria;

	@Enumerated(EnumType.STRING)
	private CorEnum cor;

	@Enumerated(EnumType.STRING)
	private TamanhoEnum tamanho;
	

	public Produto(String sku, int quantidade, double valor, String descricao) {
		super();
		this.sku = sku;
		this.quantidade = quantidade;
		this.valor = valor;
		this.descricao = descricao;

		dados();
	}

	public Produto() {
		// TODO Auto-generated constructor stub
	}
 
	public void setDepartamento(DepartamentoEnum departamento) {
		this.departamento = departamento;
	}

	public void setCategoria(CategoriaEnum categoria) {
		this.categoria = categoria;
	}

	public void setCor(CorEnum cor) {
		this.cor = cor;
	}

	public void setTamanho(TamanhoEnum tamanho) {
		this.tamanho = tamanho;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
		dados();
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public DepartamentoEnum getDepartamento() {
		return departamento;
	}

	public CategoriaEnum getCategoria() {
		return categoria;
	}

	public CorEnum getCor() {
		return cor;
	}

	public TamanhoEnum getTamanho() {
		return tamanho;
	}

	// tive que refazer
	private void dados() {
		this.categoria = CategoriaEnum.getCategoriaEnum(sku.substring(0, 3));
		this.cor = CorEnum.getCorEnum(sku.substring(3, 6));
		this.departamento = DepartamentoEnum.getDepartamentoEnum(sku.substring(6, 9));
		this.tamanho = TamanhoEnum.getTamanhoEnum(sku.substring(9, 12));
	}

	@Override
	public String toString() {
		return "\nSKU:" + sku + "\nQuantidade:" + quantidade + "\nValor:" + valor + "\nDescricao:" + descricao + ", "
				+ categoria + ", " + cor + "," + departamento + ", " + tamanho + "\n";
	}

}
