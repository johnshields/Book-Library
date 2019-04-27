package com.sales.exceptions;

public class BookAlreadyOnLoan extends RuntimeException{
	public BookAlreadyOnLoan(String message){
		super(message);
	}
}
