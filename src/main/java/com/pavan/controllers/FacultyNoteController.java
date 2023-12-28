package com.pavan.controllers;
import com.pavan.dao.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.pavan.dto.*;
public class FacultyNoteController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String status="";
		ModelAndView mav = null;
		String fn_id = request.getParameter("id");
		String fn_note = request.getParameter("note");
		String fn_state = request.getParameter("state");
		
		FacultyNote fn = new FacultyNote();
		fn.setFn_id(fn_id);
		fn.setFn_note(fn_note);
		fn.setFn_state(fn_state);
		
		FacultyDao fdao = new FacultyDaoImpl();
		
		status = fdao.addFacultyNote(fn);
		
		if(status.equals("success")){
			mav = new ModelAndView("status","message","Successfully Submitted");
		}else {
			mav = new ModelAndView("status","message","Failed");
		}
		return mav;
	}

}
