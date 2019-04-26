package com.sales.controllers;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sales.models.Book;
import com.sales.models.Customer;
import com.sales.models.Loan;
import com.sales.services.BookService;
import com.sales.services.CustomerService;
import com.sales.services.LoanService;

@Controller
@SessionAttributes({ "books" , "loans", "customers" })
public class MainController {

	@Autowired
	BookService bs;
	
	@Autowired
	CustomerService cs;
	
	@Autowired
	LoanService ls;
	
	// list all books
	@RequestMapping(value = "/showBooks", method=RequestMethod.GET)
	public String GetBooks(Model model) {
		//List<Book> books = bookService.findAll();
		System.out.print("showBooks");
		// list books
		List<Book> books = (List<Book>) bs.findAll();
		model.addAttribute("books", books);
			return "showBooks";
	} 

	//add book
	@RequestMapping(value = "/addBook", method = RequestMethod.GET)
	public String getAddBook(@ModelAttribute("book") Book book, HttpServletRequest h) {

		return "addBook";
	}

	//post book
	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public String postBook(@Valid @ModelAttribute("book") Book book,BindingResult result) {

		if(result.hasFieldErrors()) {			
			return "addBook";
		}else{
			bs.save(book);
			return "redirect:showBooks";
		}
		
	}
	
	// list all customers
	@RequestMapping(value = "/showCustomers", method=RequestMethod.GET)                   
	public String GetCustomers(Model model) {
		System.out.print("showCustomers");
		// list customers
		List<Customer> customers = (List<Customer>) cs.findAll();
		model.addAttribute("customers", customers);
			return "showCustomers";
	} 
	
	
	//add customer
	@RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
	public String getAddCustomer(@ModelAttribute("customer") Customer customer, HttpServletRequest h) {

		return "addCustomer";
	}

	//post customer
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public String postCustomer(@Valid @ModelAttribute("customer") Customer customer,BindingResult result) {

		if(result.hasFieldErrors()) {			
			return "addCustomer";
		}else{
			cs.save(customer);
			return "redirect:showCustomers";
		}
		
	}
	
	// list all loans
	@RequestMapping(value = "/showLoans", method=RequestMethod.GET)                   
	public String GetLoans(Model model) {
		System.out.print("showLoans");
		// list customers
		List<Loan> loans = (List<Loan>) ls.findAll();
		model.addAttribute("loans", loans);
			return "showLoans";
	} 
	
	
	//add loan
    @RequestMapping(value = "/newLoan", method = RequestMethod.GET)
    public String getLoan(@ModelAttribute("loan") Loan loan, HttpServletRequest h) {
      return "newLoan";
    }
    
    //post loan
    @RequestMapping(value = "/newLoan", method = RequestMethod.POST)
    public String postLoan(@Valid @ModelAttribute("loan") Loan loan,BindingResult result) {

      if(result.hasFieldErrors()) {      
        return "newLoan";
      }else{
        ls.save(loan);
        return "redirect:showLoans";
      }
    }

	
}

