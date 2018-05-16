package com.coupon.exceptions;

@SuppressWarnings("serial")
public class ConnectionClosedException extends Exception
{

	/** (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 * 
	 **/
	@Override
	public String getMessage()
	{
		// TODO Auto-generated method stub
		return "Connection Error: The Connection to the System is Closed Now ";
	}

}
