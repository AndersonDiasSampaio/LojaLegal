package com.cdb.Enum;

import java.util.Map;
import java.util.HashMap;

public enum CorEnum {
	AZUL("azu"),
	VERDE("ver"),
    AMARELO("ama"),
	PRETO("pre");
 	
	private String cor;
    
    private static final Map<String, CorEnum>getCor = new HashMap<>();
    
    CorEnum(String cor) {
    	this.cor = cor;
      }

    public String getCor() {
    	return cor;
    }
    
  // tive que refazer
    static {
    	for (CorEnum cor: CorEnum.values() ) {
    		getCor.put(cor.getCor(), cor);
    	}
    	
    }
    public static CorEnum getCorEnum(String cor) {
    	return getCor.get(cor); 
    	
    }
    
}
