package com.cognizant.loan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.loan.model.Loan;
import com.cognizant.loan.service.LoanService;

@RestController
@RequestMapping("/loan")
public class LoanController {

	@Autowired
	LoanService loanService;
	
	@GetMapping("/loans/{number}")
	public Loan getDetails(@PathVariable long number) {
		return loanService.getDetails(number); 
	}
}
