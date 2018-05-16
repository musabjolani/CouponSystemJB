package com.coupon.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date ;
import com.coupon.beans.Coupon;
import com.coupon.beans.Customer;
import com.coupon.enums.EnmCouponType;
import com.coupon.services.CouponService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CouponSystemManagerTester
{
	@Autowired
	private CouponService couponService;
//	@Autowired
//	private CustomerService customerService;

	@Test
	public void contextLoads()
	{
		
		System.out.println("Hello");
		
		Coupon coupon;
		Customer customer;
		List<Coupon> coupons= new ArrayList<Coupon>();
		List<Customer> customers= new ArrayList<Customer>();
		
		try
		{
			System.out.println("Test");
			
			
		
			
			customer=new Customer();
			customer.setCUST_NAME("Samer");
			customer.setPASSWORD("mine");
			
			customers.add(customer);
			
			DateFormat formatter = new SimpleDateFormat("yyyy-dd-MM");
			
			Date StartDate = new Date(formatter.parse("2017-4-1").getTime());
			Date EndDate = new java.sql.Date(formatter.parse("2018-10-11").getTime());
			
			coupon = new Coupon();
			coupon.setTITLE("Light");
			coupon.setTYPE(EnmCouponType.ELECTRICITY.toString());
			coupon.setAMOUNT(88);
			coupon.setPRICE(8.3);
			coupon.setSTART_DATE(StartDate);
			coupon.setEND_DATE(EndDate);
			coupon.setIMAGE("C:\\Dir Goood-welcome");
			coupon.setMESSAGE("good luck ");
			
			 StartDate = new Date(formatter.parse("2017-3-2").getTime());
			 EndDate = new java.sql.Date(formatter.parse("2018-9-7").getTime());
			 coupon.setCustomers(customers);
			 
			 
			 coupons.add(coupon);
				
			//coupon = new Coupon();
			coupon.setTITLE("Power");
			coupon.setTYPE(EnmCouponType.HEALTH.toString());
			coupon.setAMOUNT(70);
			coupon.setPRICE(3.6);
			coupon.setSTART_DATE(StartDate);
			coupon.setEND_DATE(EndDate);
			coupon.setIMAGE("C:\\WelcomeImagesFolder11");
			coupon.setMESSAGE("have a nice day ");
			
			coupons.add(coupon);
			
		
			
			
			
			customer.setCoupons(coupons);
			
			
		//	couponService.purchaseCoupon(coupons, customer);
			
			System.out.println("COOOL");
			
		}
		catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
