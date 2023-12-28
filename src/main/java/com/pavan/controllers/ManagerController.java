package com.pavan.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import com.pavan.dao.*;

import java.util.Date;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ManagerController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse arg1) throws Exception {
		String id = request.getParameter("id");
		String choice = request.getParameter("choice");
		FacultyDao fdao =null;
		ModelAndView mav = null;
		if(choice.equals("forward")) {
			fdao = new FacultyDaoImpl();
			
			
			String status= fdao.addDirector(id);
			String status123 = fdao.deleteFromManager(id);
			if(status.equals("success")) {
				mav = new ModelAndView("status","message","Succcessfully Forwarded");
			}else {
				mav = new ModelAndView("status","message","Not Forwarded");
			}
		}else if(choice.equals("reject")) {
			fdao = new FacultyDaoImpl();
			Date currentDate = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", new Locale("en", "IN"));
			String formattedDate = dateFormat.format(currentDate);
			fdao.addAdmin(formattedDate, id, choice);
			choice = formattedDate + " " + choice;
			fdao.statusUpdate(id, choice);
			String status= fdao.deleteFromManager(id);
			
			if(status.equals("success")) {
				mav = new ModelAndView("status","message","Succcessfully Rejected");
			}else {
				mav = new ModelAndView("status","message","Not Rejected");
			}
			
		}
			
		return mav;
	}

}
