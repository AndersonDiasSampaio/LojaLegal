package com.cdb.Enum;

import java.util.HashMap;
import java.util.Map;

public enum DepartmentEnum {
	MASCULINO("MAS"),
	FEMININO("FEM"),
	INFANTIL("INF");
	
	
	private String department;
	
	private static final Map<String, DepartmentEnum>getDepartment = new HashMap<>();
	
	
	DepartmentEnum(String departamento) {
		this.department = departamento;
	}

	public String getDepartamento() {
		return department;
	}

	 static {
		 for(DepartmentEnum department: DepartmentEnum.values()) {
			 getDepartment.put(department. getDepartamento(), department);
			  
		 }
	 }
	 
	 
	  public static DepartmentEnum getDepartamentoEnum(String departamento) {
		  return getDepartment.get(departamento);
	  }
}
