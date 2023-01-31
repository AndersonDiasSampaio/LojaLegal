package com.cdb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cdb.model.Venda;

@Service
public class CashRegisterService {

	public CashRegisterService() {
		// TODO Auto-generated constructor stub
	}
	public Double getCash(List<Venda> SellData) {
		Double a=0d;
		Venda sell= new Venda();
		for(int x=0;x< SellData.size();x++) {
			sell=(Venda) SellData.get(x);
			a=sell.getTotal()+a;
		}
		return a;
	}
}
