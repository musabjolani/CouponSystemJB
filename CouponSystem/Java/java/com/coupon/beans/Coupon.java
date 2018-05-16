package com.coupon.beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@SuppressWarnings("serial")
@Entity(name = "Coupon")
@XmlRootElement
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Coupon implements Serializable
{
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	@Column
	private String TITLE;
	@Column
	private Date START_DATE;
	@Column
	private Date END_DATE;
	@Column
	private int AMOUNT;
	@Column
	private String TYPE;
	@Column
	private String MESSAGE;
	@Column
	private double PRICE;
	@Column
	private String IMAGE;
	@ManyToOne(fetch = FetchType.EAGER )
	@JoinColumn(name = "company_id", referencedColumnName = "ID")
	private Company company;
	@ManyToMany
	@JoinTable(name = "coupon_customer", joinColumns = @JoinColumn(name = "coupon_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "ID"))
	private List<Customer> customers;

	public Coupon()
	{
		super();
	}

	public Coupon(int iD, String tITLE, Date sTART_DATE, Date eND_DATE, int aMOUNT, String tYPE, String mESSAGE, double pRICE, String iMAGE)
	{
		super();
		ID = iD;
		TITLE = tITLE;
		START_DATE = sTART_DATE;
		END_DATE = eND_DATE;
		AMOUNT = aMOUNT;
		TYPE = tYPE;
		MESSAGE = mESSAGE;
		PRICE = pRICE;
		IMAGE = iMAGE;
	}

	public int getID()
	{
		return ID;
	}

	public void setID(int iD)
	{
		ID = iD;
	}

	public String getTITLE()
	{
		return TITLE;
	}

	public void setTITLE(String tITLE)
	{
		TITLE = tITLE;
	}

	public Date getSTART_DATE()
	{
		return START_DATE;
	}

	public void setSTART_DATE(Date sTART_DATE)
	{
		START_DATE = sTART_DATE;
	}

	public Date getEND_DATE()
	{
		return END_DATE;
	}

	public void setEND_DATE(Date eND_DATE)
	{
		END_DATE = eND_DATE;
	}

	public int getAMOUNT()
	{
		return AMOUNT;
	}

	public void setAMOUNT(int aMOUNT)
	{
		AMOUNT = aMOUNT;
	}

	public String getTYPE()
	{
		return TYPE;
	}

	public void setTYPE(String tYPE)
	{
		TYPE = tYPE;
	}

	public String getMESSAGE()
	{
		return MESSAGE;
	}

	public void setMESSAGE(String mESSAGE)
	{
		MESSAGE = mESSAGE;
	}

	public double getPRICE()
	{
		return PRICE;
	}

	public void setPRICE(double pRICE)
	{
		PRICE = pRICE;
	}

	public String getIMAGE()
	{
		return IMAGE;
	}

	public void setIMAGE(String iMAGE)
	{
		IMAGE = iMAGE;
	}
//
//	public List<Customer> getCustomers()
//	{
//		return customers;
//	}

	public void setCustomers(List<Customer> customers)
	{
		this.customers = customers;
	}

//	 public Company getCompany()
//	 {
//	 return company;
//	 }
	public void setCompany(Company company)
	{
		this.company = company;
	}

	@Override
	public String toString()
	{
		return "Coupon [ID=" + ID + ", TITLE=" + TITLE + ", START_DATE=" + START_DATE + ", END_DATE=" + END_DATE + ", AMOUNT=" + AMOUNT + ", TYPE=" + TYPE
				+ ", MESSAGE=" + MESSAGE + ", PRICE=" + PRICE + ", IMAGE=" + IMAGE + ", company=" + company + ", customers=" + customers + "]";
	}
}
