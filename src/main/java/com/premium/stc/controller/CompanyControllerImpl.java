package com.premium.stc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.premium.stc.model.Company;
import com.premium.stc.service.*;
@Controller
public class CompanyControllerImpl implements CompanyController {
	@Autowired
	private CompanyService companyService;
	
	public Company insertCompany(Company company) throws Exception {
		return companyService.insertCompany(company);
	}

	
	public Company updateCompany(Company company) throws Exception {
		return companyService.updateCompany(company);
	}


	public List<Company> getCompanyList() throws Exception {
		return companyService.getCompanyList();
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
		
		CompanyController controller=(CompanyController)applicationContext.getBean("companyControllerImpl");
		
		Company company=new Company(1009, "insofys",232.23,"sdf","sdf",1,"sdf",343);
		controller.insertCompany(company);
	
		Company company1=new Company(1006, "cts",232.23,"sdf","sdf",1,"sdf",343);
		controller.updateCompany(company1);
		
		List<Company> list=controller.getCompanyList();
		for(Company c:list)
		{
			System.out.println(c);
		}

	}

}
