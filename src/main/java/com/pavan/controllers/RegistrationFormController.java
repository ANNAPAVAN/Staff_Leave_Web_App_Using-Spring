package com.pavan.controllers;
import com.pavan.dao.*;
import com.pavan.dto.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegistrationFormController implements Controller {
	private JdbcTemplate jdbcTemplate;
	String status="";
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		
		String fid = request.getParameter("id");
		String fname= request.getParameter("name");
		String fpwd = request.getParameter("pwd");
		String femail = request.getParameter("email");
		String role = request.getParameter("role");
		
		Faculty fct = new Faculty();
		fct.setFid(fid);
		fct.setFname(fname);
		fct.setFpwd(fpwd);
		fct.setFemail(femail);
		fct.setRole(role);
		
		FacultyDao fdao = new FacultyDaoImpl();
		status = fdao.addFaculty(fct);
		
//		System.out.println(status);
		if(status.equals("success")){
			mav = new ModelAndView("status","message","Registration Successful");
		}else {
			mav = new ModelAndView("status","message","Registration Fail");
		}
		return mav;
	}

}
