package com.coupon.exceptions;


@SuppressWarnings("serial")
public class CouponExistsException extends Exception
{
	@Override
	public String getMessage()
	{
		
		return "Error Inseting Row: This Coupon title is already exist ";
		
	}
	
	
}
