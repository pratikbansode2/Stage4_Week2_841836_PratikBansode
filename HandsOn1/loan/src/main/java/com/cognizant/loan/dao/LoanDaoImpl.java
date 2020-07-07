package com.cognizant.loan.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.loan.model.Loan;

@Repository
public class LoanDaoImpl implements LoanDao{

	@Override
	public Loan getDetails(long number) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("loan.xml");
		List<Loan> loanList=context.getBean("loanList",ArrayList.class);
		
		return loanList.stream().filter(loan->(loan.getNumber()==number)).findFirst().orElse(null);
	}

}
