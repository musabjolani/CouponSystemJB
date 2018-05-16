package com.coupon.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coupon.demo.CouponSystem;
import com.coupon.enums.EnmClientType;
import com.coupon.exceptions.InCorrectUserNamePasswordException;
import com.coupon.facades.AdminFacade;
import com.coupon.facades.CompanyFacade;
import com.coupon.facades.CouponClientFacade;
import com.coupon.facades.CustomerFacade;

@Controller
public class LoginServlet
{
	@Autowired
	private CouponSystem couponSystem;
	private CouponClientFacade couponClientFacade;
	
	

	@RequestMapping(method = RequestMethod.POST, value = "/loginServlet")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		String userName = request.getParameter("UserName");
		String password = request.getParameter("Password");
		String clientType = request.getParameter("clientType");
		// adminFacade
		// switch (request.getParameter("clientType")
		// case: ADMIN
		response.setContentType("text/html");
		// Actual logic goes here.
		PrintWriter out;
		try
		{
			couponClientFacade = couponSystem.login(userName, password, clientType);
			
			if (couponClientFacade != null)
			{
				request.getSession().setAttribute("facade", couponClientFacade);
				
				if (couponClientFacade instanceof AdminFacade)
				{
					response.sendRedirect("http://localhost:9090/AdminScreen/index.html");
				}
				else if(couponClientFacade instanceof CompanyFacade)
				{
					response.sendRedirect("http://localhost:9090/CompanyScreen/index.html?companyID="
								+ CouponSystem.getLoginCompany().getID()  + "&companyName=" +CouponSystem.getLoginCompany().getCOMP_NAME()); 
				}
				else if(couponClientFacade instanceof CustomerFacade)
				{
					response.sendRedirect("http://localhost:9090/CustomerScreen/index.html?customerID=" 
											+ CouponSystem.getLoginCustomer().getID() + "&customerName=" +CouponSystem.getLoginCustomer().getCUST_NAME()
											 + "&password="+CouponSystem.getLoginCustomer().getPASSWORD()  );
				}
			}
			else 
			{
				
				
				out = response.getWriter();
				out.println("<h1> NOT AUTHORIZED</h1>");
			}
			
			
			
			
			
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (InCorrectUserNamePasswordException e1)
		{
			try
			{
				out = response.getWriter();
				out.println("<h1> Eroor </h1>");
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
