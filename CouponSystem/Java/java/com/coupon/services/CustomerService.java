package com.coupon.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coupon.beans.Company;
import com.coupon.beans.Coupon;
import com.coupon.beans.Customer;
import com.coupon.repo.CouponRepo;
import com.coupon.repo.CustomerRepo;

@Service
public class CustomerService
{
	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private CouponRepo couponRepo;

	public Customer getCustomer(int id)
	{
		return customerRepo.getCustomer(id);
	}
	
	public Customer getCustomer(String name )
	{
		return customerRepo.getCustomer(name);
	}

	public void createCustomer(Customer c)
	{
		customerRepo.save(c);
	}

	public void updateCustomer(Customer c)
	{
		customerRepo.save(c);
	}

	public void removeCustomer(Customer customer)
	{
		
		for (Coupon coupon : customer.getCoupons())
			couponRepo.delete(coupon);
		
		customerRepo.delete(customer.getID());
	}

	public List<Customer> getAllCustomers()
	{
		return customerRepo.getAllCustomers();
	}
	
	public boolean login(String name, String password) 
	{
			
		Customer customer =  customerRepo.login(name, password);
		
		
		
		return !(customer==null);
		
	}
}
