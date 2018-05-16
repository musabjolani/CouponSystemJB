package com.coupon.beans;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Id;

import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity(name = "Company")
@XmlRootElement
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Company implements Serializable
{
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	@Column(name = "COMP_NAME", unique = true)
	private String COMP_NAME;
	@Column(name = "PASSWORD")
	private String PASSWORD;
	@Column(name = "Email")
	private String Email;
	@OneToMany(mappedBy = "company", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Coupon> coupons;

	public Company()
	{
		super();
	}

	/**
	 * @param id
	 * @param compName
	 * @param password
	 * @param email
	 */
	public Company(int id, String compName, String password, String email)
	{
		super();
		this.ID = id;
		this.COMP_NAME = compName;
		this.PASSWORD = password;
		this.Email = email;
	}

	/**
	 * @param compName
	 * @param password
	 * @param email
	 */
	public Company(String compName, String password, String email)
	{
		super();
		this.COMP_NAME = compName;
		this.PASSWORD = password;
		this.Email = email;
	}

	public int getID()
	{
		return ID;
	}

	public void setID(int iD)
	{
		ID = iD;
	}

	public String getCOMP_NAME()
	{
		return COMP_NAME;
	}

	public void setCOMP_NAME(String cOMP_NAME)
	{
		COMP_NAME = cOMP_NAME;
	}

	public String getPASSWORD()
	{
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD)
	{
		PASSWORD = pASSWORD;
	}

	public String getEmail()
	{
		return Email;
	}

	public void setEmail(String email)
	{
		Email = email;
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
		return "Company [ID=" + ID + ", COMP_NAME=" + COMP_NAME + ", PASSWORD=" + PASSWORD + ", Email=" + Email + ", coupons=" + coupons + "]";
	}
}
