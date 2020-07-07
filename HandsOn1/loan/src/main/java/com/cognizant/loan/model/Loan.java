package com.cognizant.loan.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@NoArgsConstructor
public class Loan {

	private long number;
	private String type;
	private long loan;
	private long emi;
	private long tenure;
}
