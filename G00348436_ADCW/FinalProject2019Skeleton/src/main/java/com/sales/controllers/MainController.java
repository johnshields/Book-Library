package com.sales.controllers;

import java.util.List;
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

import com.sales.exceptions.BookAlreadyOnLoan;
import com.sales.exceptions.BookNotFound;
import com.sales.exceptions.BooknCustomerNotFound;
import com.sales.exceptions.LoanNotFound;
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
		System.out.print("showBooks");
		// list books
		//List<Book> books = (List<Book>) bs.findAll();
		List<Book> books = bs.findAll();
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

		// blank error
		if(result.hasFieldErrors()) {			
			return "addBook";
		// save/add button - redirects to showBooks
		}
		else{
			bs.save(book);
			return "redirect:showBooks";
		}	
		// only need to do for loan, to catch the error
//		try
//	      {
//			  cs.save(book);
//		  }
//	      catch (BooknCustomerNotFound e){
//				m.addAttribute("error", e);
//				return "newLoanError";
//			}
//	     return "redirect:showBooks";
	}
	
    //delete book // not exactly working
    @RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
    public String getDeleteBook(@ModelAttribute("book") Book book, HttpServletRequest h) {
      return "deleteBook";
    }
    
    //post delete book
    @RequestMapping(value = "/deleteBook", method = RequestMethod.POST)
    public String deleteBook(@Valid @ModelAttribute("book") Book book,BindingResult result, Model m) {

    	// delete book
    	if(result.hasFieldErrors()) 
    	{
			return "deleteBook";
		}
    	else
    	{
            bs.delete(book);
        }
    	//delete exception
		try
		{
			bs.delete(book);
		}
		catch (BookNotFound e)
		{
			m.addAttribute("error", e);
			//go to LoanNotFound.jsp
			return "BookNotFound";
		}
//		// button redirects to List of Loans
		return "redirect:showBooks";
    }
	
	// list all customers
	@RequestMapping(value = "/showCustomers", method=RequestMethod.GET)                   
	public String GetCustomers(Model model) {
		System.out.print("showCustomers");
		// list customers
		//List<Customer> customers = (List<Customer>) cs.findAll();
		List<Customer>customers = cs.findAll();
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
	public String postCustomer(@Valid @ModelAttribute("customer") Customer customer,BindingResult result, Model m) {

		// blank error
		if(result.hasFieldErrors()) {			
			return "addCustomer";
		// save/add button - redirects to showCustomers
		}
		else{
			cs.save(customer);
			return "redirect:showCustomers";
		}	
	 }
	
	
	// list all loans
	@RequestMapping(value = "/showLoans", method=RequestMethod.GET)                   
	public String GetLoans(Model model) {
		System.out.print("showLoans");
		// list customers
		//List<Loan> loans = (List<Loan>) ls.findAll();
		List<Loan> loans = ls.findAll();
		model.addAttribute("loans", loans);
			return "showLoans";
	} 
	
	
	//add loan - due date not working
    @RequestMapping(value = "/newLoan", method = RequestMethod.GET)
    public String getNewLoan(@ModelAttribute("loan") Loan loan, HttpServletRequest h) {
      return "newLoan";
    }
    
    //post loan
    @RequestMapping(value = "/newLoan", method = RequestMethod.POST)
    public String postNewLoan(@Valid @ModelAttribute("loan") Loan loan,BindingResult result, Model m) {

      // blank error
      if(result.hasFieldErrors()) 
      {      
        return "newLoan";
      // save/add button - redirects to showLoans
      }
//      else
//      {
//          ls.save(loan);
//      }
      try
      {
		  ls.save(loan);
	  }
      catch (BooknCustomerNotFound | BookAlreadyOnLoan e){
			m.addAttribute("error", e);
			return "newLoanError";
		}
     return "redirect:showLoans";
    }
    
    //delete loan
    @RequestMapping(value = "/deleteLoan", method = RequestMethod.GET)
    public String getDeleteLoan(@ModelAttribute("loan") Loan loan, HttpServletRequest h) {
      return "deleteLoan";
    }
    
    //post delete loan
    @RequestMapping(value = "/deleteLoan", method = RequestMethod.POST)
    public String deleteLoan(@Valid @ModelAttribute("loan") Loan loan,BindingResult result, Model m) {

    	// delete loan
    	if(result.hasFieldErrors()) 
    	{
			return "deleteLoan";
		}
//    	else
//    	{
//            ls.delete(loan);
//        }
    	//delete exception // not exactly working
		try
		{
			ls.delete(loan);
		}
		catch (LoanNotFound e)
		{
			m.addAttribute("error", e);
			//go to LoanNotFound.jsp
			return "LoanNotFound";
		}
		// button redirects to List of Loans
		return "redirect:showLoans";
    }
     
    // security - login // not exactly working
    @RequestMapping(value = "/login", method=RequestMethod.GET)
	public String login(Model model) {
		
		return "login";		
	} 
    
    // security - logout 
    @RequestMapping(value = "/logout", method=RequestMethod.GET)
	public String logout(Model model) {
		
		return "logout";		
	} 
}

