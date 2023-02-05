package com.cdb.Enum;

import java.util.HashMap;
import java.util.Map;

public enum CategoryEnum {
    
	SIMPLES("SIM"),
	BORDADA("BOR"),
	CAMISA("POL"),
	SOCIAL("SOC");
	
	private String category;
 	
	private static final Map<String, CategoryEnum> getCategory = new HashMap<>();
 
	
	CategoryEnum(String category) {
		this.category = category; 
	}
	
	public String getCategoria() {
		return category;
	}
	static {
		for (CategoryEnum category: CategoryEnum.values()) {
			getCategory.put(category.getCategoria(), category);
			 
		}
		
	}
	
	public static CategoryEnum getCategoriaEnum(String category) {
		return getCategory.get(category);
	}
 
}
