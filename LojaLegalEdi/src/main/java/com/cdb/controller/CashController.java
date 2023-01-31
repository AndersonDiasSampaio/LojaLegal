package com.cdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cdb.service.CashRegisterService;
import com.cdb.service.VendasService;

@RestController
public class CashController {
	@Autowired
	VendasService vendaService;
	@Autowired
	CashRegisterService cashService;
	public CashController() {
		// TODO Auto-generated constructor stub
	}
	@RequestMapping(method = RequestMethod.GET, value = "/cash")
	public Double getCashInRegister() {
		return this.cashService.getCash(this.vendaService.getSellDataList());
	}
}
