package com.coupon.exceptions;

@SuppressWarnings("serial")
public class CustomerExistsException extends Exception
{

	@Override
	public String getMessage()
	{

		return "Error Inseting Row: This customer name is already exist ";

	}
}
