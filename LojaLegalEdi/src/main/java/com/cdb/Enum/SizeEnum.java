package com.cdb.Enum;

import java.util.HashMap;
import java.util.Map;

public enum SizeEnum {
	PEQUENO("PEQ"),
	MEDIO("MED"),
	GRANDE("GRA");
 
	private  String size;
    private static final Map<String, SizeEnum>getSize = new HashMap<>();
	
   SizeEnum(String tamanho) {
		 this.size = tamanho;
		  
	}
 
       public String getTamanho() {
       	return size;
       }
       
       
       static {
       	for (SizeEnum size: SizeEnum.values() ) {
       		getSize.put(size.getTamanho(), size);
       	}
       	
       }
       public static SizeEnum getTamanhoEnum(String tamanho) {
       	return getSize.get(tamanho); 
       	
       }
       
}
 