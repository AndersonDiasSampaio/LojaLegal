package com.cdb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import com.cdb.Enum.PaymentEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "pagamento")
@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Pagamento implements Serializable {
	private static final long serialVersionUID = 1L;
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	@Column
	private String codigo;
	@Enumerated(EnumType.STRING)
	private PaymentEnum tipo;

	@OneToMany(mappedBy = "tipoDePagamento", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Sell> Vendas = new ArrayList();

	public long getId() {
		return id;
	}

	public List<Sell> getVendas() {
		return Vendas;
	}

	public Pagamento() {

	}

	public String getCodigo() {
		return codigo;
	}

	public void setTipo(String tipo) {
		this.codigo = tipo;
	}

	public PaymentEnum getTipo() {
		return tipo;
	}

	public void setCodigo(String codigo) {
		this.tipo = PaymentEnum.getCategoriaEnum(codigo);
	}

	public Pagamento(String tipo, PaymentEnum codigo, List<Sell> vendas) {
		super();
		this.codigo = tipo;
		this.tipo = codigo;
		Vendas = vendas;
	}

	@Override
	public String toString() {
		return "Pagamento [id=" + id + ", codigo=" + codigo + ", tipo=" + tipo + "]";
	}

}
