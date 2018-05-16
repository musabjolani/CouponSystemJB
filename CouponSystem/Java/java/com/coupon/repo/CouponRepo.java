package com.coupon.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.coupon.beans.Coupon;

public interface CouponRepo extends CrudRepository<Coupon, Integer>
{
	
	@Query("Select c from Coupon c where c.ID =(:id)")
	public Coupon getCoupon(@Param("id") int id);
	
	@Query("Select c from Coupon c ")
	public List<Coupon > getAllCoupons();
	
	@Query("Select c from Coupon c join c.customers cust where cust.ID =(:id)")
	public List<Coupon > getAllPurchasedCoupons(@Param("id") int id);
	
	@Query("Select c from Coupon c join c.customers cust where cust.ID =(:id) AND c.TYPE =(:type) ")
	public List<Coupon > getAllPurchasedCouponsByType(@Param("id") int id,@Param("type") String type);
	
	@Query("Select c from Coupon c join c.customers cust where cust.ID =(:id) AND c.PRICE >=(:price)")
	public List<Coupon > getAllPurchasedCouponsByPrice(@Param("id") int id,@Param("price") double price);
}


