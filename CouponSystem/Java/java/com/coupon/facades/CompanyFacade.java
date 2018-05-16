package com.coupon.facades;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.coupon.beans.Company;
import com.coupon.beans.Coupon;
import com.coupon.enums.EnmClientType;
import com.coupon.exceptions.CompanyExistsException;
import com.coupon.exceptions.ConnectionClosedException;
import com.coupon.exceptions.CouponExistsException;
import com.coupon.exceptions.InCorrectUserNamePasswordException;
import com.coupon.repo.CompanyRepo;
import com.coupon.services.CompanyService;
import com.coupon.services.CouponService;

@Service
public class CompanyFacade implements CouponClientFacade
{
	@Autowired
	private CouponService couponServive;
	@Autowired
	private CompanyService companyServive;
	

	
	public void createCoupon(Coupon coupon) throws SQLException, CouponExistsException, InterruptedException, ConnectionClosedException, ClassNotFoundException
	{
		couponServive.createCoupon(coupon);
	}

	public void updateCoupon(Coupon coupon) throws SQLException, CouponExistsException, InterruptedException, ConnectionClosedException, ClassNotFoundException
	{
		couponServive.createCoupon(coupon);
	}

	public void removeCoupon(Coupon coupon) throws SQLException, InterruptedException, ConnectionClosedException, ClassNotFoundException
	{
		couponServive.removeCoupon(coupon);
	}

	public Coupon getCoupon(int id) throws SQLException, InterruptedException, ConnectionClosedException
	{
		return couponServive.getCoupon(id);
	}

	public Set<Coupon> getAllCouponsOfCompany(int id) throws SQLException, InterruptedException, ConnectionClosedException
	{
		return companyServive.getAllCouponsOfCompany(id);
	}

	public List<Coupon> getAllCouponsOfCompanyByType(int id, String type) throws SQLException, InterruptedException, ConnectionClosedException
	{
		return companyServive.getAllCouponsOfCompanyByType(id, type);
	}

	public List<Coupon> getAllCouponsOfCompanyByPrice(int id, double price) throws SQLException, InterruptedException, ConnectionClosedException
	{
		return companyServive.getAllCouponsOfCompanyByPrice(id, price);
	}

	public List<Coupon> getAllCouponsOfCompanyByEndDate(int id, Date date) throws SQLException, InterruptedException, ConnectionClosedException
	{
		return companyServive.getAllCouponsOfCompanyByEndDate(id, date);
	}

	@Override
	public CouponClientFacade login(String name, String password) throws InCorrectUserNamePasswordException
	{
		if (companyServive.login(name, password))
			return this;
		else
			throw new InCorrectUserNamePasswordException();
	
	}
}
