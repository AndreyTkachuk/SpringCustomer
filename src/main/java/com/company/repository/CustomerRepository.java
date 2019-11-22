
package com.company.repository;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.company.model.Customer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer , Long> {
	
	
	@Query(value = "SELECT c FROM Customer c WHERE c.name LIKE '%' || :keyword ||'%' "
			+"OR c.last_name LIKE '%' || :keyword ||'%' "
			+"OR c.email LIKE '%' || :keyword ||'%' "
			+"OR c.phone LIKE '%' || :keyword ||'%' "
			+"OR c.age LIKE '%' || :keyword ||'%' "
			+"OR c.location LIKE '%' || :keyword ||'%' ")
	public List<Customer> search(@Param("keyword")String keyword);

}
