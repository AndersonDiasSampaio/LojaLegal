package com.cdb.Enum;

import java.util.HashMap;
import java.util.Map;

public enum TamanhoEnum {
	PEQUENO("PEQ"),
	MEDIO("MED"),
	GRANDE("GRA");
 
	private  String tamanho;
    private static final Map<String, TamanhoEnum>getTamanho = new HashMap<>();
	
   TamanhoEnum(String tamanho) {
		 this.tamanho = tamanho;
		  
	}
 
       public String getTamanho() {
       	return tamanho;
       }
       
       
       static {
       	for (TamanhoEnum tamanho: TamanhoEnum.values() ) {
       		getTamanho.put(tamanho.getTamanho(), tamanho);
       	}
       	
       }
       public static TamanhoEnum getTamanhoEnum(String tamanho) {
       	return getTamanho.get(tamanho); 
       	
       }
       
}
 