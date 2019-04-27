package com.sales.security;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@EnableWebMvc
public class Security extends WebMvcConfigurerAdapter{ 
	public final static String[] URLS = new String[]{
			"/", "/showBooks", "/showCustomers", "/showLoans", 
			"/addBook", "/addCustomer", "/newLoan", "/deleteLoan"
	};

}