package com.coupon.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.coupon.controllers.AdminContraller;
import com.coupon.facades.AdminFacade;
import com.coupon.facades.CompanyFacade;
import com.coupon.services.CompanyService;
import  com.coupon.servlets.LoginServlet;; 



@SpringBootApplication(scanBasePackageClasses = {AdminContraller.class,AdminFacade.class, CompanyFacade.class,CompanyService.class,LoginServlet.class,CouponSystem.class})
@EntityScan(basePackages = "com.coupon.beans")
@EnableJpaRepositories(basePackages = "com.coupon.repo")
public class CouponSystemManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CouponSystemManagerApplication.class, args);
		
		
	}
}
