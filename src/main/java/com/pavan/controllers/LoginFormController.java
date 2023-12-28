package com.pavan.controllers;

import java.util.*;
import com.pavan.dao.*;
import com.pavan.dto.Admin;
import com.pavan.dto.Faculty;
import com.pavan.dto.FacultyNote;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginFormController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		
		String fid = request.getParameter("id");
		String fname = request.getParameter("name");
		String fpwd = request.getParameter("pwd");
		String role = request.getParameter("role");
		FacultyDao fdao = new FacultyDaoImpl();
//		System.out.println("ANNAPAVAN");

		Faculty fct = fdao.search(fid);
//		System.out.println(fct.getFpwd());
//		System.out.println(fpwd);
		
		if(fct!=null && fct.getFpwd().equals(fpwd) && fct.getRole().equals(role))
		{
//			System.out.println("ANNAPAVAN");
			if(role.equals("teacher")){
				List<String> lst = new ArrayList<>();
				String sts = fdao.getStatus(fid);
				lst.add(fname);
				lst.add(sts);
				mav = new ModelAndView("facultypage","lst",lst);
			}else if(role.equals("manager")){
				List<FacultyNote> list_fn =  fdao.searchFacultyNotes();
//				System.out.println("data received "+list_fn);
//				for(FacultyNote ap:list_fn)
//				{
//					System.out.println(ap.getFn_id());
//				}
				mav = new ModelAndView("managerpage","list_fn",list_fn);
//				mav = new ModelAndView("managerpage","name",fname);
			}else if(role.equals("director")) {
				List<FacultyNote> list_fn =  fdao.searchDirectTable();
//				System.out.println("data received "+list_fn);
//				for(FacultyNote ap:list_fn)
//				{
//					System.out.println(ap.getFn_id());
//				}
				mav = new ModelAndView("directorpage","list_fn",list_fn);
			}else if(role.equals("admin")) {
				List<Admin> admin_list = fdao.searchAdmin();
				mav = new ModelAndView("adminpage","admin_list",admin_list);
			}
//			System.out.println("ANNAPAVAN--success");
//			mav = new ModelAndView("status","message","Login Successful");
		}else {
//			System.out.println("ANNAPAVAN--fail");
			mav = new ModelAndView("status","message","Login Failure");
		}
		
		return mav;
	}

}
