package com.coupon.controllers;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.coupon.beans.Company;
import com.coupon.beans.Customer;
import com.coupon.demo.CouponSystem;
import com.coupon.enums.EnmClientType;
import com.coupon.exceptions.CompanyExistsException;
import com.coupon.exceptions.ConnectionClosedException;
import com.coupon.exceptions.CustomerExistsException;
import com.coupon.exceptions.InCorrectUserNamePasswordException;
import com.coupon.facades.AdminFacade;



@CrossOrigin(origins="*")
@RestController
public class AdminContraller
{
	//@Autowired
	private AdminFacade adminFacade;


	
	private AdminFacade getAdminFacade(HttpServletRequest request)
	{
		
		
		//CouponSystem couponSystem = new CouponSystem();
		try
		{
		//	CouponClientFacade couponClientFacade = couponSystem.login("admin", "1234", EnmClientType.ADMIN.toString());
			
		//	return (AdminFacade)couponSystem.login("admin", "1234", EnmClientType.ADMIN.toString());
			return (AdminFacade) request.getSession().getAttribute("facade");
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Incorect password");
			return null;
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getCompany/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Company getCompany(@PathVariable int id,HttpServletRequest request) throws ClassNotFoundException, SQLException, InterruptedException, ConnectionClosedException
	{
		
		adminFacade=this.getAdminFacade(request);
		
		
		return adminFacade.getCompany(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/createCompany", consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void createCompany(@RequestBody Company company,HttpServletRequest request)
			throws ClassNotFoundException, SQLException, CompanyExistsException, InterruptedException, ConnectionClosedException,Exception
	{
		adminFacade=this.getAdminFacade(request);
		adminFacade.createCompany(company);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/removeCompany")
	public @ResponseBody void removeCompany(@RequestBody Company company,HttpServletRequest request)
			throws ClassNotFoundException, SQLException, CompanyExistsException, InterruptedException, ConnectionClosedException
	{
		adminFacade=this.getAdminFacade(request);
		adminFacade.removeCompany(company);
	}
	@RequestMapping(method = RequestMethod.PUT, value = "/updateCompany", consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void updateCompany(@RequestBody Company company,HttpServletRequest request)
			throws ClassNotFoundException, SQLException, CompanyExistsException, InterruptedException, ConnectionClosedException
	{
		adminFacade=this.getAdminFacade(request);
		adminFacade.updateCompany(company);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getAllCompanies", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Company> getAllCompanies(HttpServletRequest request) throws ClassNotFoundException, SQLException, InterruptedException, ConnectionClosedException
	{
		adminFacade=this.getAdminFacade(request);
		
		return adminFacade.getAllCompanies();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getCustomer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Customer getCustomer(@PathVariable int id,HttpServletRequest request) throws ClassNotFoundException, SQLException, InterruptedException, ConnectionClosedException
	{
		adminFacade=this.getAdminFacade(request);
		return adminFacade.getCustomer(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/updateCustomer", consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void updateCompany(@RequestBody Customer customer,HttpServletRequest request)
			throws ClassNotFoundException, SQLException, CompanyExistsException, InterruptedException, ConnectionClosedException
	{
		adminFacade=this.getAdminFacade(request);
		adminFacade.updateCustomer(customer);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/createCustomer", consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void createCustomer(@RequestBody Customer customer,HttpServletRequest request)
			throws ClassNotFoundException, SQLException, CompanyExistsException, InterruptedException, ConnectionClosedException, CustomerExistsException
	{
		adminFacade=this.getAdminFacade(request);
		adminFacade.createCustomer(customer);
	}
	
	
	
	
	//@RequestMapping(method = RequestMethod.DELETE, value = "/removeCustomer/{id}")
	@RequestMapping(method = RequestMethod.DELETE, value = "/removeCustomer")
	public @ResponseBody void removeCustomer(@RequestBody Customer customer,HttpServletRequest request)
			throws ClassNotFoundException, SQLException, CompanyExistsException, InterruptedException, ConnectionClosedException
	{
		adminFacade=this.getAdminFacade(request);
		adminFacade.removeCustomer(customer);
		
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getAllCustomers", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Customer> getAllCustomers(HttpServletRequest request) throws ClassNotFoundException, SQLException, InterruptedException, ConnectionClosedException
	{
		adminFacade=this.getAdminFacade(request);
		return adminFacade.getAllCustomers();
	}
	
	
	
}
