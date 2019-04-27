package com.sales.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.services.BookService;
import com.sales.exceptions.BookNotFound;
import com.sales.models.Book;
import com.sales.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	public List<Book> findAll() {
		return (List<Book>) bookRepository.findAll();
	}
	
	public Book save(Book book) {
		return bookRepository.save(book);
	}
	
	//find book to delete
	public Book findBook(Long bid){
		return bookRepository.findOne(bid);
	}
	
	//delete book
	public void delete(Book book)throws BookNotFound{
		//find one book selected to delete
		bookRepository.findOne(book.getBid());
		if(bookRepository == null) 
		{
			//exception error for BookNotFound
			throw new BookNotFound("No such Book: " + book.getBid());
		}
		//delete loan
		bookRepository.delete(book);
	}

}