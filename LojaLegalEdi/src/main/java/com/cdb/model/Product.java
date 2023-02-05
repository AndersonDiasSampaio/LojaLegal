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
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	@Column
	private String sku;
	@Column
	private int quantity;
	@Column
	private double value;
	@Column
	private String description;

	@Enumerated(EnumType.STRING)
	private DepartamentoEnum department;

	@Enumerated(EnumType.STRING)
	private CategoriaEnum category;

	@Enumerated(EnumType.STRING)
	private CorEnum color;

	@Enumerated(EnumType.STRING)
	private TamanhoEnum size;
	

	public Product(String sku, int quantity, double value, String description) {
		super();
		this.sku = sku;
		this.quantity = quantity;
		this.value = value;
		this.description = description;

		dados();
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}
 
	public void setDepartment(DepartamentoEnum department) {
		this.department = department;
	}

	public void setCategory(CategoriaEnum category) {
		this.category = category;
	}

	public void setColor(CorEnum color) {
		this.color = color;
	}

	public void setSize(TamanhoEnum size) {
		this.size = size;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
		dados();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DepartamentoEnum getDepartment() {
		return department;
	}

	public CategoriaEnum getCategory() {
		return category;
	}

	public CorEnum getCorlor() {
		return color;
	}

	public TamanhoEnum getSize() {
		return size;
	}

	// tive que refazer
	private void dados() {
		this.category = CategoriaEnum.getCategoriaEnum(sku.substring(0, 3));
		this.color = CorEnum.getCorEnum(sku.substring(3, 6));
		this.department = DepartamentoEnum.getDepartamentoEnum(sku.substring(6, 9));
		this.size = TamanhoEnum.getTamanhoEnum(sku.substring(9, 12));
	}

	@Override
	public String toString() {
		return "\nSKU:" + sku + "\nQuantidade:" + quantity + "\nValor:" + value + "\nDescricao:" + description + ", "
				+ category + ", " + color + "," + department + ", " + size + "\n";
	}

}
