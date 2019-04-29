package com.sales.exceptions;

public class BooknCustomerNotFound extends RuntimeException
{
	public BooknCustomerNotFound(String message)
	{
		super(message);
	}
}
