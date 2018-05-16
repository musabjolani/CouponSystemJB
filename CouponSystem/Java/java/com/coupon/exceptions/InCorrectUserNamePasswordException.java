package com.coupon.exceptions;

@SuppressWarnings("serial")
public class InCorrectUserNamePasswordException extends Exception
{

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage()
	{
		// TODO Auto-generated method stub
		return "Error Loggin: Incorrect user name or password Please try again !!!!! ";
	}

}
