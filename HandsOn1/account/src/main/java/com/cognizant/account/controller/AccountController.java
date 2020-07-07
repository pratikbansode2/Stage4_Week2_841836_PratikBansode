package com.cognizant.account.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.account.model.Account;
import com.cognizant.account.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@GetMapping("/accounts/{number}")
	public Account getBalance(@PathVariable long number) {
		return accountService.getBalance(number);
	}
}
