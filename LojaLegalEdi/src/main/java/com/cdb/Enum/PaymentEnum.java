package com.cdb.Enum;

import java.util.HashMap;
import java.util.Map;

public enum PaymentEnum {
	PIX("PIX"), CARTAO_DE_CREDITO("CRED"), CARTAO_DE_DEBITO("DEB"), DINHEIRO("DIN");

	PaymentEnum(String string) {
		this.payment = string;
		// TODO Auto-generated constructor stub
	}

	private String payment;

	private static final Map<String, PaymentEnum> getPaymentMap = new HashMap<>();

	public String getPagamento() {
		return payment;
	}
	static {
		for (PaymentEnum payment: PaymentEnum.values()) {
			getPaymentMap.put(payment.getPagamento(), payment);
			 
		}
		
	}
	public static PaymentEnum getCategoriaEnum(String categoria) {
		return getPaymentMap.get(categoria);
	}
}
