package com.cdb.Enum;

import java.util.HashMap;
import java.util.Map;

public enum DepartamentoEnum {
	MASCULINO("MAS"),
	FEMININO("FEM"),
	INFANTIL("INF");
	
	
	private String departamento;
	
	private static final Map<String, DepartamentoEnum>getDepartamento = new HashMap<>();
	
	
	DepartamentoEnum(String departamento) {
		this.departamento = departamento;
	}

	public String getDepartamento() {
		return departamento;
	}

	 static {
		 for(DepartamentoEnum departamento: DepartamentoEnum.values()) {
			 getDepartamento.put(departamento. getDepartamento(), departamento);
			  
		 }
	 }
	 
	 
	  public static DepartamentoEnum getDepartamentoEnum(String departamento) {
		  return getDepartamento.get(departamento);
	  }
}
