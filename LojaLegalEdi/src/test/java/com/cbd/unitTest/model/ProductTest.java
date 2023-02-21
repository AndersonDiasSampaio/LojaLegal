package com.cbd.unitTest.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.cdb.Enum.CategoryEnum;
import com.cdb.Enum.ColorEnum;
import com.cdb.Enum.DepartmentEnum;
import com.cdb.Enum.SizeEnum;
import com.cdb.model.Product;

public class ProductTest {

	public ProductTest() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void createProductBlankAtributsTest() {
		Product product = new Product();
		assertThat(product.getCategory()).isEqualTo(null);
		assertThat(product.getColor()).isEqualTo(null);
		assertThat(product.getDepartment()).isEqualTo(null);
		assertThat(product.getSize()).isEqualTo(null);

	}

	@Test
	public void createProductAtributsTest() {
		SizeEnum size = SizeEnum.PEQUENO;
		CategoryEnum category = CategoryEnum.SIMPLES;
		ColorEnum color = ColorEnum.AZUL;
		DepartmentEnum department = DepartmentEnum.MASCULINO;
		Product product = new Product("SIMazuMASPEQ", 20, 30, "Produto de Teste");
		assertThat(product.getCategory()).isEqualTo(category);
		assertThat(product.getColor()).isEqualTo(color);
		assertThat(product.getDepartment()).isEqualTo(department);
		assertThat(product.getSize()).isEqualTo(size);
		Product product2 = new Product("SIMazuMASPE", 20, 30, "Produto de Teste");
		assertThat(product2.getCategory()).isEqualTo(null);
		assertThat(product2.getColor()).isEqualTo(null);
		assertThat(product2.getDepartment()).isEqualTo(null);
		assertThat(product2.getSize()).isEqualTo(null);
		product2.setSku("SIMazuMASPEQ");
		product2.setQuantity(30);
		product2.setValue(50d);
		product2.setDescription("Segundo produto de Teste");
		assertThat(product2.getSku()).isEqualTo("SIMazuMASPEQ");
		assertThat(product2.getQuantity()).isEqualTo(30);
		assertThat(product2.getDescription()).isEqualTo("Segundo produto de Teste");
		assertThat(product2.getValue()).isEqualByComparingTo(50d);
		assertThat(product2.getCategory()).isEqualTo(category);
		assertThat(product2.getColor()).isEqualTo(color);
		assertThat(product2.getDepartment()).isEqualTo(department);
		assertThat(product2.getSize()).isEqualTo(size);

	}

}
