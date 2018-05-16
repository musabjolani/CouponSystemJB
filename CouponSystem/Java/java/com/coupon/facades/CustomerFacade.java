package com.coupon.facades;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coupon.beans.Coupon;
import com.coupon.beans.Customer;
import com.coupon.enums.EnmClientType;
import com.coupon.exceptions.ConnectionClosedException;
import com.coupon.exceptions.CouponSameTypeExistsException;
import com.coupon.exceptions.InCorrectUserNamePasswordException;
import com.coupon.exceptions.NoAmoutCouponsException;
import com.coupon.services.CouponService;
import com.coupon.services.CustomerService;

@Service
public class CustomerFacade implements CouponClientFacade
{
	@Autowired
	private CouponService couponService;
	@Autowired
	private CustomerService customerService;
	
	public void purchaseCoupon(Customer customer)
			throws InterruptedException, SQLException, NoAmoutCouponsException, CouponSameTypeExistsException, ConnectionClosedException, ClassNotFoundException
	{
		
		couponService.purchaseCoupon(customer);
	}
	
	
	
	public List<Coupon> getAllCoupons()
	{
		return couponService.getAllCoupons();
	}
	
	
	public List<Coupon> getAllPurchasedCoupons(int id)
	{
		return couponService.getAllPurchasedCoupons(id);
		
	}
	
	public List<Coupon> getAllPurchasedCouponsByType(int id,String type)
	{
		return couponService.getAllPurchasedCouponsByType(id,type);
		
	}
	public List<Coupon> getAllPurchasedCouponsByType(int id,double price)
	{
		return couponService.getAllPurchasedCouponsByType(id,price);
		
	}

	
	
	
	@Override
	public CouponClientFacade login(String name, String password)throws InCorrectUserNamePasswordException
	{
		if (customerService.login(name, password))
			return this;
		else
			throw new InCorrectUserNamePasswordException();
	}
}
