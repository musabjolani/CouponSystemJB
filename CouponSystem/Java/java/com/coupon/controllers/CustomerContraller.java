package com.coupon.controllers;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.coupon.beans.Coupon;
import com.coupon.beans.Customer;
import com.coupon.exceptions.CompanyExistsException;
import com.coupon.exceptions.ConnectionClosedException;
import com.coupon.exceptions.CouponSameTypeExistsException;
import com.coupon.exceptions.NoAmoutCouponsException;
import com.coupon.facades.CustomerFacade;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CustomerContraller
{
	@Autowired
	private CustomerFacade customerFacade;

	// List<Coupon> coupons, Customer customer
	@RequestMapping(method = RequestMethod.POST, value = "/purchaseCoupon", consumes = MediaType.APPLICATION_JSON_VALUE)
	//public @ResponseBody void purchaseCoupon(@RequestBody List<Coupon> coupons,@RequestBody Customer customer) throws ClassNotFoundException, SQLException,
	public @ResponseBody void purchaseCoupon(@RequestBody Customer customer) throws ClassNotFoundException, SQLException,
			CompanyExistsException, InterruptedException, ConnectionClosedException, NoAmoutCouponsException, CouponSameTypeExistsException
	{
		
		System.out.println(customer);
		customerFacade.purchaseCoupon(customer);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getAllCoupons", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Coupon> getAllCoupons()
			throws ClassNotFoundException, SQLException, InterruptedException, ConnectionClosedException
	{
		return customerFacade.getAllCoupons();
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/getAllPurchasedCoupons/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Coupon> getAllPurchasedCoupons(@PathVariable int id)
			throws ClassNotFoundException, SQLException, InterruptedException, ConnectionClosedException
	{
		return customerFacade.getAllPurchasedCoupons(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getAllPurchasedCouponsByType/{id}/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Coupon> getAllPurchasedCouponsByType(@PathVariable int id, @PathVariable String type)
			throws ClassNotFoundException, SQLException, InterruptedException, ConnectionClosedException
	{
		return customerFacade.getAllPurchasedCouponsByType(id, type);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getAllPurchasedCouponsByPrice/{id}/{price:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Coupon> getAllPurchasedCouponsByType(@PathVariable int id, @PathVariable double price)
			throws ClassNotFoundException, SQLException, InterruptedException, ConnectionClosedException
	{
		return customerFacade.getAllPurchasedCouponsByType(id, price);
	}
}
