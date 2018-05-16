package com.coupon.exceptions;

@SuppressWarnings("serial")
public class NoAmoutCouponsException extends Exception
{

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage()
	{
		return "Error Inseting Row: There is no amount of coupon to buy  ";
	}

}
