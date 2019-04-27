package com.sales.exceptions;

public class LoanNotFound extends RuntimeException{
	public LoanNotFound(String message){
		super(message);
	}

}
