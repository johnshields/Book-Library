package com.sales.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.exceptions.BooknLoanNotFound;
import com.sales.models.Loan;
import com.sales.repositories.LoanRepository;

@Service
public class LoanService {
	
	@Autowired
	LoanRepository loanRepository;
	
	//show loans
	public List<Loan> findAll() {
		return (List<Loan>) loanRepository.findAll();
	}
	
	//add loan
	public Loan save(Loan loan) {
		return loanRepository.save(loan);
	}
	
	//find loan to delete
	public Loan findLoan(Long lid){
		return loanRepository.findOne(lid);
	}
	
	//delete loan
	public void delete(Loan loan)throws BooknLoanNotFound{
		//find one loan selected to delete
		loanRepository.findOne(loan.getLid());
		if(loanRepository ==null) 
		{
			//exception error for LoanNotFound
			throw new BooknLoanNotFound("No such Loan: " + loan.getLid());
		}
		//delete loan
		loanRepository.delete(loan);
	}
}
