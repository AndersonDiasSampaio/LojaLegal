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
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	@Column
	private String code;
	@Enumerated(EnumType.STRING)
	private PaymentEnum type;

	@OneToMany(mappedBy = "tipoDePagamento", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Sell> sales = new ArrayList();

	public long getId() {
		return id;
	}

	public List<Sell> getSales() {
		return sales;
	}

	public Payment() {

	}

	public String getCode() {
		return code;
	}

	public void setCode(String tipo) {
		this.code = tipo;
	}

	public PaymentEnum getTipo() {
		return type;
	}

	public void setType(String type) {
		
		this.type = PaymentEnum.getCategoriaEnum(type);
	}

	public Payment(String tipo, PaymentEnum codigo, List<Sell> vendas) {
		super();
		this.code = tipo;
		this.type = codigo;
		sales = vendas;
	}

	@Override
	public String toString() {
		return "Pagamento [id=" + id + ", codigo=" + code + ", tipo=" + type + "]";
	}

}
