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
		// attribute in jsp page
		model.addAttribute("books", books);
			// returns List of Books
			return "showBooks";
	} 

	//add book
	@RequestMapping(value = "/addBook", method = RequestMethod.GET)
	public String getAddBook(@ModelAttribute("book") Book book, HttpServletRequest h) {
		// returns add book Page
		return "addBook";
	}

	//post book
	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public String postBook(@Valid @ModelAttribute("book") Book book,BindingResult result) {

		// blank/invalid input error
		if(result.hasFieldErrors()) {			
			return "addBook";
		// save/add button - redirects to showBooks
		}
		else
		{
			// saves add book
			bs.save(book);
			// redirects to List Of Books
			return "redirect:showBooks";
		}	
	}
	
	// trying out delete a book
    //delete book // not exactly working
    @RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
    public String getDeleteBook(@ModelAttribute("book") Book book, HttpServletRequest h) {
      // returns delete Book Page
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
    	// save the delete
    	else
    	{
            bs.delete(book);
        }
    	//delete exception
		try
		{
			bs.delete(book);
		}
		// book does not exist exception error
		catch (BookNotFound e)
		{
			m.addAttribute("error", e);
			//go to LoanNotFound.jsp
			return "BookNotFound";
		}
//		// redirects to List of Books
		return "redirect:showBooks";
    }
	
	// list all customers
	@RequestMapping(value = "/showCustomers", method=RequestMethod.GET)                   
	public String GetCustomers(Model model) {
		System.out.print("showCustomers");
		// list customers
		//List<Customer> customers = (List<Customer>) cs.findAll();
		List<Customer>customers = cs.findAll();
		// attribute in jsp page
		model.addAttribute("customers", customers);
		// returns to List Of Customers
			return "showCustomers";
	} 
	
	
	//add customer
	@RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
	public String getAddCustomer(@ModelAttribute("customer") Customer customer, HttpServletRequest h) {
		// returns add Customer Page
		return "addCustomer";
	}

	//post customer
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public String postCustomer(@Valid @ModelAttribute("customer") Customer customer,BindingResult result, Model m) {

		// blank/invalid input error
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
		// attribute in jsp page
		model.addAttribute("loans", loans);
			// returns List of Loans
			return "showLoans";
	} 
	
	//add loan
    @RequestMapping(value = "/newLoan", method = RequestMethod.GET)
    public String getNewLoan(@ModelAttribute("loan") Loan loan, HttpServletRequest h) {
     // returns New Loan Page
      return "newLoan";
    }
    
    //post new loan
    @RequestMapping(value = "/newLoan", method = RequestMethod.POST)
    public String postNewLoan(@Valid @ModelAttribute("loan") Loan loan,BindingResult result, Model m) {

      // blank/invalid input error
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
      // book or customer does not exist + book already on loan exception
      catch (BooknCustomerNotFound | BookAlreadyOnLoan e){
			m.addAttribute("error", e);
			return "newLoanError";
		}
      // redirects to List Of Loans
     return "redirect:showLoans";
    }
    
    //delete loan
    @RequestMapping(value = "/deleteLoan", method = RequestMethod.GET)
    public String getDeleteLoan(@ModelAttribute("loan") Loan loan, HttpServletRequest h) {
      // returns to delete Loan page
      return "deleteLoan";
    }
    
    //post delete loan
    @RequestMapping(value = "/deleteLoan", method = RequestMethod.POST)
    public String deleteLoan(@Valid @ModelAttribute("loan") Loan loan,BindingResult result, Model m) {
    	
    	// delete blank/invalid loan error
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
			//error message
			m.addAttribute("error", e);
			//go to LoanNotFound.jsp
			return "LoanNotFound";
		}
		// button redirects to List of Loans
		return "redirect:showLoans";
    }
     
    // security - login
    @RequestMapping(value = "/login", method=RequestMethod.GET)
	public String login(Model model) {
		// return login security
		return "login";		
	} 
    
    // security - logout 
    @RequestMapping(value = "/logout", method=RequestMethod.GET)
	public String logout(Model model) {
    	// return login security
		return "logout";		
	} 
}

