package com.coupon.demo;

import static org.junit.Assert.*;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.coupon.beans.Company;
import com.coupon.beans.Coupon;
import com.coupon.beans.Customer;
import com.coupon.enums.EnmCouponType;
import com.coupon.services.CompanyService;
import com.coupon.services.CouponService;
import com.coupon.services.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CouponTest
{
	@Autowired
	private CouponService couponService;
	
	@Autowired
	private CustomerService customerService;

	
	@Autowired
	private CompanyService companyService;
	
	
	@Test
	public void test()
	{
		// @Autowired
		// private CustomerService customerService;
		System.out.println("Cooooooooooool");
		System.out.println("Hello");
		Coupon coupon;
		Customer customer;
		List<Coupon> coupons = new ArrayList<Coupon>();
		//List<Customer> customers = new ArrayList<Customer>();
		
		Company company = new Company();
		company.setID(34);
		company.setCOMP_NAME("Oracle");
		company.setEmail("musab@Oracle.com");
		company.setPASSWORD("12001200");
				
		
		try
		{
			System.out.println("Test");
			customer = new Customer();
			customer.setID(5);
			customer.setCUST_NAME("Samer");
			customer.setPASSWORD("mine");
		//	customers.add(customer);
			DateFormat formatter = new SimpleDateFormat("yyyy-dd-MM");
			Date StartDate = new Date(formatter.parse("2017-2-2").getTime());
			Date EndDate = new java.sql.Date(formatter.parse("2018-7-11").getTime());
			coupon = new Coupon();
			coupon.setID(9);
			coupon.setTITLE("Power");
			coupon.setTYPE(EnmCouponType.HEALTH.toString());
			coupon.setAMOUNT(70);
			coupon.setPRICE(3.6);
			coupon.setSTART_DATE(StartDate);
			coupon.setEND_DATE(EndDate);
			coupon.setIMAGE("C:\\niceDay");
			coupon.setMESSAGE("ave a nice day");
			//coupon.setCustomers(customers);
			coupon.setCompany(company);
			coupons.add(coupon);
			StartDate = new Date(formatter.parse("2017-7-2").getTime());
			EndDate = new java.sql.Date(formatter.parse("2018-5-7").getTime());
			
			coupon = new Coupon();
			coupon.setID(18);
			coupon.setTITLE("My Colombia !!!");
			coupon.setTYPE(EnmCouponType.SPORTS.toString());
			coupon.setAMOUNT(43);
			coupon.setPRICE(9.1);
			coupon.setSTART_DATE(StartDate);
			coupon.setEND_DATE(EndDate);
			coupon.setIMAGE("C:\\CoolMbiaa");
			coupon.setMESSAGE("good luck Colombia !!!");
		//	coupon.setCustomers(customers);
			coupons.add(coupon);
			coupon.setCompany(company);
			
			//customer.setCoupons(coupons);
		//couponService.purchaseCoupon(coupons, customer);
//			
//			couponService.updateCoupon(coupon);
			
			//couponService.createCoupon(coupon);
		//	System.out.println(companyService.getAllCouponsOfCompany(2));
		//for( Coupon coup :	companyService.getAllCouponsOfCompany(2))
		//System.out.println(coup);
			
//			customerService.createCustomer(customer);
	//		Set<Coupon>test =companyService.getAllCouponsOfCompany(2);
//			for( Coupon coup :	test)
//				System.out.println(coup.getID());
//			
			System.out.println("GOOOOOOOOOOD JOOOOOOOOOOB");
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
