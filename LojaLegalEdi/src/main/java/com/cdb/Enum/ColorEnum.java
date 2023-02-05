package com.cdb.Enum;

import java.util.Map;
import java.util.HashMap;

public enum ColorEnum {
	AZUL("azu"),
	VERDE("ver"),
    AMARELO("ama"),
	PRETO("pre");
 	
	private String color;
    
    private static final Map<String, ColorEnum>getColor = new HashMap<>();
    
    ColorEnum(String color) {
    	this.color = color;
      }

    public String getCor() {
    	return color;
    }
    
  // tive que refazer
    static {
    	for (ColorEnum color: ColorEnum.values() ) {
    		getColor.put(color.getCor(), color);
    	}
    	
    }
    public static ColorEnum getCorEnum(String color) {
    	return getColor.get(color); 
    	
    }
    
}
