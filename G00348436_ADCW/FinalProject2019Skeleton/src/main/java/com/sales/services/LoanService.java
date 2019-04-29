package com.sales.services;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.exceptions.LoanNotFound;
import com.sales.models.Loan;
import com.sales.repositories.LoanRepository;

@Service
public class LoanService {
	
//	public static void main(String[] args) {
//	      LoanService calUsage = new LoanService();
//	      calUsage.Loan();
//	}
	
	@Autowired
	LoanRepository loanRepository;
	
	private DateFormat SimpleDateFormat = new SimpleDateFormat("YYYY-MM-DD");
	private Calendar cal = Calendar.getInstance();
	
	//show loans
	public List<Loan> findAll() {
		return (List<Loan>) loanRepository.findAll();
	}

	//add loan //save loan
	public Loan save(Loan loan) {
		
		//Set calendar to 29th November 2019
	     Calendar cal = new GregorianCalendar(2019, Calendar.NOVEMBER, 29);
		
		//update dueDate for loan period 
		cal.add(Calendar.DAY_OF_YEAR, loan.getCust().getLoanPeriod());
		cal.add(Calendar.DAY_OF_MONTH, loan.getCust().getLoanPeriod());
		//String dueDate = dateFormat.format(calendar.getDueDate()); 
    	String dueDate = SimpleDateFormat.format(cal.getTime()); 
    	System.out.println(dueDate);
    	loan.setDueDate(dueDate);
    	//save loan
		return loanRepository.save(loan);
	}
	
	//find loan to delete
	public Loan findLoan(Long lid){
		return loanRepository.findOne(lid);
	}
	
	//delete loan 
	public void delete(Loan loan)throws LoanNotFound{
		//find one loan selected to delete
		loanRepository.findOne(loan.getLid());
		if(loanRepository == null) 
		{
			//exception error for LoanNotFound
			throw new LoanNotFound("No such Loan: " + loan.getLid());
		}
		//delete loan
		loanRepository.delete(loan);
	}
}
