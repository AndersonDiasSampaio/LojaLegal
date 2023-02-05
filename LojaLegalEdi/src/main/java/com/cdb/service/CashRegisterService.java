package com.cdb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cdb.model.Sell;

@Service
public class CashRegisterService {

	public CashRegisterService() {
		// TODO Auto-generated constructor stub
	}
	public Double getCash(List<Sell> SellData) {
		Double a=0d;
		Sell sell= new Sell();
		for(int x=0;x< SellData.size();x++) {
			sell=(Sell) SellData.get(x);
			a=sell.getTotal()+a;
		}
		return a;
	}
}
