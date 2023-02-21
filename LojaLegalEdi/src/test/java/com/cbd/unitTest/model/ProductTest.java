package com.cbd.unitTest.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.cdb.model.Product;

public class ProductTest {

	public ProductTest() {
		// TODO Auto-generated constructor stub
	}
	@Test
	public void createProductTest() {
		Product product= new Product();
		assertThat(product.getCategory()).isEqualTo(null);
	}
}
