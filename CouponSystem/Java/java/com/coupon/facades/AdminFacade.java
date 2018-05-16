package com.coupon.facades;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coupon.beans.Company;
import com.coupon.beans.Customer;
import com.coupon.enums.EnmClientType;
import com.coupon.exceptions.CompanyExistsException;
import com.coupon.exceptions.ConnectionClosedException;
import com.coupon.exceptions.CustomerExistsException;
import com.coupon.exceptions.InCorrectUserNamePasswordException;
import com.coupon.services.CompanyService;
import com.coupon.services.CustomerService;

@Service
public class AdminFacade implements CouponClientFacade
{
	@Autowired
	private CompanyService companyService;
	@Autowired
	private CustomerService customerService;

	/**
	 * Getting a Company row from the company table
	 * 
	 * @author Musab
	 * @param id Company id as a query to get a company row from the table
	 * @return Company Object that contains a company profile
	 * @exception SQLException Thrown when there is a database access error
	 * @exception InterruptedException Thrown when the connection thread is interrupted
	 * @exception ConnectionClosedException Thrown when the system connection is closed .
	 */
	public Company getCompany(int id) throws ClassNotFoundException, SQLException, InterruptedException, ConnectionClosedException
	{
		return companyService.getCompany(id);
		
	}
	
	public Company getCompany(String companyName) throws ClassNotFoundException, SQLException, InterruptedException, ConnectionClosedException
	{
		return companyService.getCompany(companyName);
		
	}

	/**
	 * Creating a new company
	 * 
	 * @author Musab
	 * @param company the Company object to create a new company
	 * @exception ClassNotFoundException Thrown when an application tries to load in a class through its string name but no definition could be found.
	 * @exception SQLException Thrown when there is a database access error
	 * @exception CompanyExistsException Thrown when trying to create a new company that is already exist
	 * @exception InterruptedException Thrown when the connection thread is interrupted
	 * @exception ConnectionClosedException Thrown when the system connection is closed .
	 * 
	 */
	public void createCompany(Company company)
			throws ClassNotFoundException, SQLException, CompanyExistsException, InterruptedException, ConnectionClosedException,Exception
	{
		companyService.createCompany(company);
	}

	public void removeCompany(Company company) throws ClassNotFoundException, SQLException, CompanyExistsException, InterruptedException, ConnectionClosedException
	{
		companyService.removeCompany(company);
	}

	public void updateCompany(Company company)
			throws ClassNotFoundException, SQLException, CompanyExistsException, InterruptedException, ConnectionClosedException
	{
		companyService.updateCompany(company);
	}

	public List<Company> getAllCompanies() throws ClassNotFoundException, SQLException, InterruptedException, ConnectionClosedException
	{
		return companyService.getAllCompanies();
	}

	public Customer getCustomer(int id)
	{
		return customerService.getCustomer(id);
	}
	
	public Customer getCustomer(String name)
	{
		return customerService.getCustomer(name);
	}

	public void createCustomer(Customer customer)
			throws SQLException, CustomerExistsException, InterruptedException, ConnectionClosedException, ClassNotFoundException
	{
		customerService.createCustomer(customer);
	}
	
	
	public void updateCustomer(Customer customer) throws SQLException, InterruptedException, ConnectionClosedException, ClassNotFoundException
	{
		customerService.updateCustomer(customer);
	}
	
	public void removeCustomer(Customer customer) throws SQLException, InterruptedException, ConnectionClosedException, ClassNotFoundException
	{
		customerService.removeCustomer(customer);
		
	}
	
	
	public List<Customer> getAllCustomers() throws SQLException, InterruptedException, ConnectionClosedException, ClassNotFoundException
	{
		return customerService.getAllCustomers();
		
	}
	
	@Override
	public CouponClientFacade login(String name, String password) throws InCorrectUserNamePasswordException
	{
		if (name.equals("admin") && password.equals("1234"))
			return this;
		else
			throw new InCorrectUserNamePasswordException();
	}
}
