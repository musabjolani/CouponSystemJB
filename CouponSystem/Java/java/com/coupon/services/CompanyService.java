package com.coupon.services;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.coupon.beans.Company;
import com.coupon.beans.Coupon;
import com.coupon.exceptions.CompanyExistsException;
import com.coupon.exceptions.InCorrectUserNamePasswordException;
import com.coupon.repo.CompanyRepo;

@Service
public class CompanyService
{
	@Autowired
	private CompanyRepo companyRepo;

	public Company getCompany(int id)
	{
		return companyRepo.getCompany(id);
	}

	public Company getCompany(String comapnyName)
	{
		return companyRepo.getCompany(comapnyName);
	}
	public void createCompany(Company c) throws CompanyExistsException, Exception
	{
		try
		{
			System.out.print("Company Name " + c.getCOMP_NAME() + "  ID " + c.getID());
			companyRepo.save(c);
		}
		catch (DataIntegrityViolationException ex)
		{
			throw new CompanyExistsException();
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
			;
		}
	}

	public void updateCompany(Company c)
	{
		companyRepo.save(c);
	}

	public void removeCompany(Company company)
	{
		companyRepo.delete(company);
	}

	public List<Company> getAllCompanies()
	{
		return companyRepo.getAllCompanies();
	}

	public Set<Coupon> getAllCouponsOfCompany(int id)
	{
		return companyRepo.getAllCouponesOfCompany(id);
	}

	public List<Coupon> getAllCouponsOfCompanyByType(int id, String type)
	{
		return companyRepo.getAllCouponsOfCompanyByType(id, type);
	}

	public List<Coupon> getAllCouponsOfCompanyByPrice(int id, double price)
	{
		return companyRepo.getAllCouponsOfCompanyByPrice(id, price);
	}

	public List<Coupon> getAllCouponsOfCompanyByEndDate(int id, Date date)
	{
		return companyRepo.getAllCouponsOfCompanyByEndDate(id, date);
	}
	
	public boolean login(String name, String password) 
	{
			
		Company company =  companyRepo.login(name, password);
		
		
		
		return !(company==null);
		
	}
	
	
}
