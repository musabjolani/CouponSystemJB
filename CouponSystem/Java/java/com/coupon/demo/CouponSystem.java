package com.coupon.demo;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coupon.beans.Company;
import com.coupon.beans.Customer;
import com.coupon.enums.EnmClientType;
import com.coupon.exceptions.ConnectionClosedException;
import com.coupon.exceptions.InCorrectUserNamePasswordException;
import com.coupon.facades.AdminFacade;
import com.coupon.facades.CompanyFacade;
import com.coupon.facades.CouponClientFacade;
import com.coupon.facades.CustomerFacade;

/**
 * the Singleton Controller class of the system
 * 
 * @author Musab
 *
 */
@Service
public class CouponSystem

{
	
	private static Company LoginCompany;
	private static Customer LoginCustomer;
	
	
	// private static CouponSystem INSTANCE = null;
	private CouponClientFacade couponClientFacade;
	@Autowired
	private AdminFacade adminFacade;
	@Autowired
	private CompanyFacade companyFacade;
	@Autowired
	private CustomerFacade customerFacade;
	// private CouponSystem()

	// public static CouponSystem getInstance()
	// {
	// if (INSTANCE == null)
	// {
	// INSTANCE = new CouponSystem();
	// }
	// return INSTANCE;
	// }
	public CouponClientFacade login(String name, String password, String clientType) throws InCorrectUserNamePasswordException, ClassNotFoundException, SQLException, InterruptedException, ConnectionClosedException
	{
		// switch (clientType)
		// {
		if (clientType.equals(EnmClientType.ADMIN.toString()))
			couponClientFacade = adminFacade;
		else if (clientType.equals(EnmClientType.COMPANY.toString()))
		{
			couponClientFacade = companyFacade;
			LoginCompany=adminFacade.getCompany(name);
			
		}
		else if (clientType.equals(EnmClientType.CUSTOMER.toString()))
		{
			couponClientFacade = customerFacade;
			LoginCustomer=adminFacade.getCustomer(name);
		
		}
		//else 
			return couponClientFacade.login(name, password);
	}
	
	public static Company getLoginCompany()
	{
		return LoginCompany;
	}
	
	public static Customer getLoginCustomer()
	{
		return LoginCustomer;
	}
}
