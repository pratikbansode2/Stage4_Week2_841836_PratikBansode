package com.cognizant.account.dao;



import com.cognizant.account.model.Account;

public interface AccountDao {
	public Account getBalance(long number);
}
