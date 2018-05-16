package com.coupon.beans;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Company Profile
 * 
 * @author Musab
 * 
 */
@SuppressWarnings("serial")
@Entity(name = "Customer")
@XmlRootElement
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Customer implements Serializable
{
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	@Column(name = "CUST_NAME", unique = true)
	private String CUST_NAME;
	@Column(name = "PASSWORD")
	private String PASSWORD;
	@ManyToMany(mappedBy = "customers")
	private List<Coupon> coupons;

	public Customer()
	{
		// TODO Auto-generated constructor stub
	}

	public Customer(int iD, String cUST_NAME, String pASSWORD, List<Coupon> coupons)
	{
		super();
		ID = iD;
		CUST_NAME = cUST_NAME;
		PASSWORD = pASSWORD;
		this.coupons = coupons;
	}

	public int getID()
	{
		return ID;
	}

	public void setID(int iD)
	{
		ID = iD;
	}

	public String getCUST_NAME()
	{
		return CUST_NAME;
	}

	public void setCUST_NAME(String cUST_NAME)
	{
		CUST_NAME = cUST_NAME;
	}

	public String getPASSWORD()
	{
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD)
	{
		PASSWORD = pASSWORD;
	}

	public List<Coupon> getCoupons()
	{
		return coupons;
	}

	public void setCoupons(List<Coupon> coupons)
	{
		this.coupons = coupons;
	}

	@Override
	public String toString()
	{
		return "Customer [ID=" + ID + ", CUST_NAME=" + CUST_NAME + ", PASSWORD=" + PASSWORD + ", coupons=" + coupons + "]";
	}
}
