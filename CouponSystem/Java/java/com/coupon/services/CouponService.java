package com.coupon.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;
import javax.transaction.TransactionManager;
import javax.annotation.Resource;

import com.coupon.beans.Coupon;
import com.coupon.beans.Customer;
import com.coupon.exceptions.CouponSameTypeExistsException;
import com.coupon.exceptions.NoAmoutCouponsException;
import com.coupon.repo.CouponRepo;
import com.coupon.repo.CustomerRepo;

import ch.qos.logback.core.net.SyslogOutputStream;

@Service
public class CouponService
{
	@Autowired
	private CouponRepo couponRepo;
	@Autowired
	private CustomerRepo customerRepo;

	// @Resource private UserTransaction tx;
	public void createCoupon(Coupon coupon)
	{
		couponRepo.save(coupon);
	}

	public void updateCoupon(Coupon coupon)
	{
		couponRepo.save(coupon);
	}

	public void removeCoupon(Coupon coupon)
	{
		
		couponRepo.delete(coupon);
	}

	public Coupon getCoupon(int id)
	{
		return couponRepo.getCoupon(id);
	}

	
	public List<Coupon> getAllCoupons()
	{
		return couponRepo.getAllCoupons();
	}
	public List<Coupon> getAllPurchasedCoupons(int id)
	{
		return couponRepo.getAllPurchasedCoupons(id);
	}

	public List<Coupon> getAllPurchasedCouponsByType(int id, String type)
	{
		return couponRepo.getAllPurchasedCouponsByType(id, type);
	}

	public List<Coupon> getAllPurchasedCouponsByType(int id, double price)
	{
		return couponRepo.getAllPurchasedCouponsByPrice(id, price);
	}

	// @Transactional
	public void purchaseCoupon( Customer customer) throws NoAmoutCouponsException, CouponSameTypeExistsException
	{
	//	List<Customer> customers = new ArrayList<Customer>();
		// customer.getCoupons().addAll(coupons);
		//customer.setCoupons(coupons);
		//customers.add(customer);
		
		for (Coupon coupon : customer.getCoupons())
		{
			if (!isCouponHasAmount(coupon.getID()))      						  // check if the coupon has an amount
				throw new NoAmoutCouponsException();
			if (isCouponTypePurchased(customer.getID(), coupon.getTYPE()))     // check if the customer has already purchased a same type coupon
				throw new CouponSameTypeExistsException();
			coupon.setAMOUNT(coupon.getAMOUNT() - 1);
		//	coupon.setCustomers(customers);
		}
		customerRepo.save(customer);
		//couponRepo.save(coupons);
	}

	private boolean isCouponHasAmount(int id)
	{
		if (couponRepo.getCoupon(id) == null) // check if empty
			return false;
		if (couponRepo.getCoupon(id).getAMOUNT() > 0)
			return true;
		else
			return false;
	}

	private boolean isCouponTypePurchased(int id, String type)
	{
		if (!(couponRepo.getAllPurchasedCouponsByType(id, type).size() == 0))
			return true;
		else
			return false;
	}
}
