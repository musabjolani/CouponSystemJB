package com.coupon.facades;

import java.sql.SQLException;

import com.coupon.enums.EnmClientType;
import com.coupon.exceptions.ConnectionClosedException;
import com.coupon.exceptions.InCorrectUserNamePasswordException;

public interface CouponClientFacade
{
	public CouponClientFacade login(String name, String password) throws  InCorrectUserNamePasswordException;
}
