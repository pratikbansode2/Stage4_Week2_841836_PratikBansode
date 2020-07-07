package com.cognizant.loan.dao;

import com.cognizant.loan.model.Loan;

public interface LoanDao {

	public Loan getDetails(long number);
}
