package com.sales.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Loan;
import com.sales.repositories.LoanRepository;

@Service
public class LoanService {
	
	@Autowired
	LoanRepository loanRepository;
	
	public List<Loan> findAll() {
		return (List<Loan>) loanRepository.findAll();
	}
	
	public Loan save(Loan loan) {
		return loanRepository.save(loan);
	}

	

}
