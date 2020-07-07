package com.cognizant.account.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.account.model.Account;

@Repository
public class AccountDaoImpl implements AccountDao{

	@Override
	public Account getBalance(long number) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("account.xml");
		List<Account> accountList=context.getBean("accountList", ArrayList.class);
		return accountList.stream().filter(account->(account.getNumber()==number)).findFirst().orElse(null);
	}

}
