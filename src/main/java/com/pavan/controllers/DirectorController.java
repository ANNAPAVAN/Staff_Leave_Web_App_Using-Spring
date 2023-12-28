package com.pavan.controllers;
import java.text.SimpleDateFormat;
import java.util.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.pavan.dao.FacultyDao;
import com.pavan.dao.FacultyDaoImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DirectorController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse arg1) throws Exception {
		String id = request.getParameter("id");
		String choice = request.getParameter("choice");
		FacultyDao fdao =null;
		ModelAndView mav = null;
		if(choice.equals("accept")) {			
			fdao = new FacultyDaoImpl();
			Date currentDate = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", new Locale("en", "IN"));
			String formattedDate = dateFormat.format(currentDate);
			fdao.addAdmin(formattedDate, id, choice);
			choice = formattedDate + " " + choice;
			fdao.statusUpdate(id, choice);
			
			String status123= fdao.deleteFromDirector(id);
			
			mav = new ModelAndView("status","message","Succcessfully Accepted");

		}else if(choice.equals("reject")) {
			fdao = new FacultyDaoImpl();
			Date currentDate = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", new Locale("en", "IN"));
			String formattedDate = dateFormat.format(currentDate);
			fdao.addAdmin(formattedDate, id, choice);
			choice = formattedDate + " " + choice;
			fdao.statusUpdate(id, choice);
			String status123= fdao.deleteFromDirector(id);
			
			mav = new ModelAndView("status","message","Succcessfully Rejected");

			
		}
			
		return mav;
	}

}
