package com.cdb.model;

import java.io.Serializable;

import com.cdb.Enum.CategoryEnum;
import com.cdb.Enum.ColorEnum;
import com.cdb.Enum.DepartmentEnum;
import com.cdb.Enum.SizeEnum;
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
	private DepartmentEnum department;

	@Enumerated(EnumType.STRING)
	private CategoryEnum category;

	@Enumerated(EnumType.STRING)
	private ColorEnum color;

	@Enumerated(EnumType.STRING)
	private SizeEnum size;
	

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
 
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	private void setDepartment(DepartmentEnum department) {
		this.department = department;
	}

	private void setCategory(CategoryEnum category) {
		this.category = category;
	}

	private void setColor(ColorEnum color) {
		this.color = color;
	}

	private void setSize(SizeEnum size) {
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

	public DepartmentEnum getDepartment() {
		return department;
	}

	public CategoryEnum getCategory() {
		return category;
	}

	public ColorEnum getColor() {
		return color;
	}

	public SizeEnum getSize() {
		return size;
	}

	// tive que refazer
	private void dados() {
		
		try {
			
		
			setCategory(CategoryEnum.getCategoriaEnum(sku.substring(0, 3)));
			setColor(ColorEnum.getCorEnum(sku.substring(3, 6)));	
			setDepartment(DepartmentEnum.getDepartamentoEnum(sku.substring(6, 9)));
			setSize(SizeEnum.getTamanhoEnum(sku.substring(9, 12)));
		
		} catch (Exception e) {
			setCategory(null);
			setColor(null);	
			setDepartment(null);
			setSize(null);
		}
	}

	@Override
	public String toString() {
		return "\nSKU:" + sku + "\nQuantidade:" + quantity + "\nValor:" + value + "\nDescricao:" + description + ", "
				+ category + ", " + color + "," + department + ", " + size + "\n";
	}

}
