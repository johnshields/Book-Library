package com.sales.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.services.CustomerService;
import com.sales.exceptions.BooknCustomerNotFound;
import com.sales.exceptions.LoanNotFound;
import com.sales.models.Customer;
import com.sales.models.Loan;
import com.sales.repositories.CustomerRepository;


@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public List<Customer> findAll() {
		return (List<Customer>) customerRepository.findAll();
	}
	
	public Customer findLoan(Long cid){
		return customerRepository.findOne(cid);
	}
	
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
//		if(customerRepository == null) 
//		{
//			//exception error for CustomerNotFound
//			throw new BooknCustomerNotFound("No such Loan: " + customer.getcName());
//		}
	}

}