package com.coupon.enums;

/**
 * Enumeration for the client types in the system (ADMIN,COMPANY,CUSTOMER)
 * 
 * @author Musab
 */
public enum EnmClientType
{
	ADMIN("ADMIN"), COMPANY("COMPANY"), CUSTOMER("CUSTOMER");
	private final String text;

	/**
	 * @param text
	 */
	EnmClientType(final String text)
	{
		this.text = text;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString()
	{
		return text;
	}
}