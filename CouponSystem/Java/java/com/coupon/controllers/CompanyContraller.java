package com.coupon.controllers;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.coupon.beans.Company;
import com.coupon.beans.Coupon;
import com.coupon.exceptions.CompanyExistsException;
import com.coupon.exceptions.ConnectionClosedException;
import com.coupon.exceptions.CouponExistsException;
import com.coupon.facades.AdminFacade;
import com.coupon.facades.CompanyFacade;

@RestController
public class CompanyContraller
{
//	@Autowired
	private CompanyFacade companyFacade;
	
	@SuppressWarnings("unused")
	private CompanyFacade getCompanyFacade(HttpServletRequest request)
	{
		
		
		//CouponSystem couponSystem = new CouponSystem();
		try
		{
		//	CouponClientFacade couponClientFacade = couponSystem.login("admin", "1234", EnmClientType.ADMIN.toString());
			
		//	return (AdminFacade)couponSystem.login("admin", "1234", EnmClientType.ADMIN.toString());
			return (CompanyFacade) request.getSession().getAttribute("facade");
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Incorect password");
			return null;
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/createCoupon", consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void createCoupon(@RequestBody Coupon coupon,HttpServletRequest request)
			throws SQLException, CouponExistsException, InterruptedException, ConnectionClosedException, ClassNotFoundException
	{
		companyFacade=this.getCompanyFacade(request);
		companyFacade.createCoupon(coupon);;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/updateCoupon", consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void updateCoupon(@RequestBody Coupon coupon ,HttpServletRequest request)
			throws SQLException, CouponExistsException, InterruptedException, ConnectionClosedException, ClassNotFoundException
	{
		companyFacade=this.getCompanyFacade(request);
		companyFacade.updateCoupon(coupon);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/removeCoupon")
	public @ResponseBody void removeCoupon(@RequestBody Coupon coupon ,HttpServletRequest request)
			throws ClassNotFoundException, SQLException, CompanyExistsException, InterruptedException, ConnectionClosedException
	{
		companyFacade=this.getCompanyFacade(request);
		companyFacade.removeCoupon(coupon);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getCoupon/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Coupon getCoupon(@PathVariable int id ,HttpServletRequest request) throws ClassNotFoundException, SQLException, InterruptedException, ConnectionClosedException
	{
	
		companyFacade=this.getCompanyFacade(request);
		return companyFacade.getCoupon(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getAllCouponsOfCompany/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Set<Coupon> getAllCouponesOfCompany(@PathVariable int id ,HttpServletRequest request)
			throws ClassNotFoundException, SQLException, InterruptedException, ConnectionClosedException
	{
		companyFacade=this.getCompanyFacade(request);
		return companyFacade.getAllCouponsOfCompany(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getAllCouponsOfCompanyByType/{id}/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Coupon> getAllCouponsOfCompanyByType(@PathVariable int id, @PathVariable String type ,HttpServletRequest request)
			throws ClassNotFoundException, SQLException, InterruptedException, ConnectionClosedException
	{
		companyFacade=this.getCompanyFacade(request);
		return companyFacade.getAllCouponsOfCompanyByType(id, type);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getAllCouponsOfCompanyByPrice/{id}/{price:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Coupon> getAllCouponsOfCompanyByType(@PathVariable int id, @PathVariable double price,HttpServletRequest request)
			throws ClassNotFoundException, SQLException, InterruptedException, ConnectionClosedException
	{
		companyFacade=this.getCompanyFacade(request);
		return companyFacade.getAllCouponsOfCompanyByPrice(id, price);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getAllCouponsOfCompanyByEndDate/{id}/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Coupon> getAllCouponsOfCompanyByDate(@PathVariable int id, @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") String date,HttpServletRequest request)
			throws ClassNotFoundException, SQLException, InterruptedException, ConnectionClosedException, ParseException
	{
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		companyFacade=this.getCompanyFacade(request);
		return companyFacade.getAllCouponsOfCompanyByEndDate(id, new java.sql.Date(formatter.parse(date).getTime()));
	}
}
