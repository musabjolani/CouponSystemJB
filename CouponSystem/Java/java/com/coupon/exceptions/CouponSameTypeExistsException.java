package com.coupon.exceptions;

@SuppressWarnings("serial")
public class CouponSameTypeExistsException extends Exception
{
	@Override
	public String getMessage()
	{
		return "Error :This coupon's type is already purchased  ";
	}
}
