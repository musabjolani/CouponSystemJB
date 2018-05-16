package com.coupon.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.coupon.beans.Customer;

public interface CustomerRepo extends CrudRepository<Customer, Integer>
{
	@Query("Select c from Customer c where c.ID =(:id)")
	public Customer getCustomer(@Param("id") int id);

	@Query("Select c from Customer c where c.CUST_NAME =(:name)")
	public Customer getCustomer(@Param("name") String name);

	@Query("Select c from Customer c order by c.CUST_NAME")
	public List<Customer> getAllCustomers();
	
	@Query("Select c from Customer c where c.CUST_NAME = (:name) AND c.PASSWORD = (:password) ")
	public Customer login(@Param("name") String name,@Param("password")  String password) ;
}
