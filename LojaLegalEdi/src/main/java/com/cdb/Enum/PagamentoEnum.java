package com.cdb.Enum;

import java.util.HashMap;
import java.util.Map;

public enum PagamentoEnum {
	PIX("PIX"), CARTAO_DE_CREDITO("CRED"), CARTAO_DE_DEBITO("DEB"), DINHEIRO("DIN");

	PagamentoEnum(String string) {
		this.pagamento = string;
		// TODO Auto-generated constructor stub
	}

	private String pagamento;

	private static final Map<String, PagamentoEnum> getPagamentoMap = new HashMap<>();

	public String getPagamento() {
		return pagamento;
	}
	static {
		for (PagamentoEnum categoria: PagamentoEnum.values()) {
			getPagamentoMap.put(categoria.getPagamento(), categoria);
			 
		}
		
	}
	public static PagamentoEnum getCategoriaEnum(String categoria) {
		return getPagamentoMap.get(categoria);
	}
}
