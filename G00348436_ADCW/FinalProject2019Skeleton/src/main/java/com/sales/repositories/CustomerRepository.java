package com.sales.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.sales.models.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{
	List<Customer> findAll();
}
