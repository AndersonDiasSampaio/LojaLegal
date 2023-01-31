package com.cdb.Enum;

import java.util.HashMap;
import java.util.Map;

public enum CategoriaEnum {
    
	SIMPLES("SIM"),
	BORDADA("BOR"),
	CAMISA("POL"),
	SOCIAL("SOC");
	
	private String categoria;
 	
	private static final Map<String, CategoriaEnum> getCategoria = new HashMap<>();
 
	
	CategoriaEnum(String categoria) {
		this.categoria = categoria; 
	}
	
	public String getCategoria() {
		return categoria;
	}
	static {
		for (CategoriaEnum categoria: CategoriaEnum.values()) {
			getCategoria.put(categoria.getCategoria(), categoria);
			 
		}
		
	}
	
	public static CategoriaEnum getCategoriaEnum(String categoria) {
		return getCategoria.get(categoria);
	}
 
}
