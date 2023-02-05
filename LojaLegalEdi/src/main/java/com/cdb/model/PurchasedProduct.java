package com.cdb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.cdb.Enum.CategoryEnum;
import com.cdb.Enum.ColorEnum;
import com.cdb.Enum.DepartmentEnum;
import com.cdb.Enum.SizeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "produto_comprado")
@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class PurchasedProduct implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
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

	@ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Sell> sells = new ArrayList();

	@JsonIgnore
	public List<Sell> getProdutos() {
		return sells;
	}

	public PurchasedProduct(String sku, int quantity, double value, String description) {
		super();
		this.sku = sku;
		this.quantity = quantity;
		this.value = value;
		this.description = description;

		dados();
	}

	public PurchasedProduct() {
		// TODO Auto-generated constructor stub
	}
 
	public void setDepartment(DepartmentEnum department) {
		this.department = department;
	}

	public void setCategory(CategoryEnum category) {
		this.category = category;
	}

	public void setColor(ColorEnum color) {
		this.color = color;
	}

	public void setSize(SizeEnum size) {
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
		this.category = CategoryEnum.getCategoriaEnum(sku.substring(0, 3));
		this.color = ColorEnum.getCorEnum(sku.substring(3, 6));
		this.department = DepartmentEnum.getDepartamentoEnum(sku.substring(6, 9));
		this.size = SizeEnum.getTamanhoEnum(sku.substring(9, 12));
	}

	@Override
	public String toString() {
		return "\nSKU:" + sku + "\nQuantidade:" + quantity + "\nValor:" + value + "\nDescricao:" + description + ", "
				+ category + ", " + color + "," + department + ", " + size + "\n";
	}

}
