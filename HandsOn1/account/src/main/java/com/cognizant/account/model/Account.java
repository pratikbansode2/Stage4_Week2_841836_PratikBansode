package com.cognizant.account.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@NoArgsConstructor@ToString
public class Account {

	
	private long number;
	private String type;
	private long balance;
}
