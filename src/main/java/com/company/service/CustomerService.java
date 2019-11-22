package com.company.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.model.Customer;
import com.company.repository.CustomerRepository;




@Service
public class CustomerService {
	
	@Autowired
	public CustomerRepository customerRepository;
	
	public List<Customer> listAll(){
		return (List<Customer>)customerRepository.findAll();
		
	}
	
    public void save (Customer customer) {
    	customerRepository.save(customer);
    }
    public Customer get(long id) {
    	Optional<Customer> result = customerRepository.findById(id);
    	
    	 return result.get();
    	
    }
    public void delete(long id) {
    	customerRepository.deleteById(id);
    }
    
    public List<Customer> search(String keyword){
    	return customerRepository.search(keyword);
    }
    
    
}
