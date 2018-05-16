package com.coupon.repo;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.coupon.beans.Company;
import com.coupon.beans.Coupon;

public interface CompanyRepo extends CrudRepository<Company, Integer>
{
	@Query("Select c from Company c where c.ID =(:id)")
	public Company getCompany(@Param("id") int id);
	
	@Query("Select c from Company c where c.COMP_NAME =(:companyName)")
	public Company getCompany(@Param("companyName") String companyName);

	@Query("Select c from Company c order by c.COMP_NAME")
	public List<Company> getAllCompanies();
	
	
	@Query("Select c from Coupon c join c.company com where com.ID =(:id)")
	public Set<Coupon> getAllCouponesOfCompany(@Param("id") int id);
	
	@Query("Select c from Coupon c join c.company com where com.ID =(:id) AND c.TYPE =(:type)")
	public List<Coupon> getAllCouponsOfCompanyByType(@Param("id") int id,@Param("type") String type);
	
	@Query("Select c from Coupon c join c.company com where com.ID =(:id) AND c.PRICE >=(:price)")
	public List<Coupon> getAllCouponsOfCompanyByPrice(@Param("id") int id,@Param("price") double price);
	
	@Query("Select c from Coupon c join c.company com where com.ID =(:id) AND c.END_DATE >=(:date)")
	public List<Coupon> getAllCouponsOfCompanyByEndDate(@Param("id") int id,@Param("date") Date date);
	
	@Query("Select c from Company c where c.COMP_NAME = (:name) AND c.PASSWORD = (:password) ")
	public Company login(@Param("name") String name,@Param("password")  String password) ;
}