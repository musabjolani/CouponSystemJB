package com.coupon.exceptions;

@SuppressWarnings("serial")
public class CompanyExistsException extends Exception
{
	@Override
	public String getMessage()
	{
		
		return "Error Inseting Row: This company name is already exist ";
		
	}
	
}
