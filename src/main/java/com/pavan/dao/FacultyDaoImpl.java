package com.pavan.dao;


import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.pavan.dto.Faculty;
import com.pavan.dto.FacultyNote;
import com.pavan.dto.Admin;
import com.pavan.mapper.*;


public class FacultyDaoImpl implements FacultyDao {

	static private JdbcTemplate jdbcTemplate;
	String status="";
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
//		System.out.println("jdbc in set method "+this.jdbcTemplate);
	}
	

	@Override
	public String addFaculty(Faculty fct) {
		
		String query1 = "select * from faculty where fid = '"+fct.getFid()+"'";
//		System.out.println("jdbc in addFaculty "+this.jdbcTemplate);
		List<Faculty> list = jdbcTemplate.query(query1,new FacultyRowMapper());
		if(list.isEmpty()) {
			String query2 = "insert into faculty values('"+fct.getFid()+"','"+fct.getFname()+"','"+fct.getFpwd()+"','"+fct.getFemail()+"','"+fct.getRole()+"')";
			String s="pending";
			String statusQuery = "insert into statustable values('"+fct.getFid()+"','"+s+"')";
			int rowCountStatus = jdbcTemplate.update(statusQuery);
			int rowCount = jdbcTemplate.update(query2);
			if(rowCount==1) {
				status="success";
			}else {
				status = "failure";
			}
		}else {
			status = "existed";
		}
		return status;
		
	}

	@Override
	public Faculty search(String fid) {
		Faculty fct = null;
		String query = "select * from faculty where fid='"+fid+"'";
		List<Faculty> fct_List = jdbcTemplate.query(query, new FacultyRowMapper());

		if(fct_List.isEmpty()) {
			fct = null;
		}else {
			fct = fct_List.get(0);
		}

		return fct;

	}
	
	@Override
	public String addFacultyNote(FacultyNote fn)
	{
		String query1 = "select * from teachertable where fn_id = '"+fn.getFn_id()+"'";
		List<FacultyNote> list = jdbcTemplate.query(query1,new FacultyNoteRowMapper());
		if(list.isEmpty()) {
			String query2 = "insert into teachertable values('"+fn.getFn_id()+"','"+fn.getFn_note()+"','"+fn.getFn_state()+"')";
			int rowCount = jdbcTemplate.update(query2);
			if(rowCount==1) {
				status="success";
			}else {
				status = "failure";
			}
		}else {
			status = "existed";
		}
		return status;
	}
	
	@Override
	public FacultyNote searchFacultyNote(String fn_id) {
		FacultyNote fn = null;
		String query = "select * from teachertable where fn_id='"+fn_id+"'";
		List<FacultyNote> fn_List = jdbcTemplate.query(query,new FacultyNoteRowMapper() );

		if(fn_List.isEmpty()) {
			fn = null;
		}else {
			fn = fn_List.get(0);
		}

		return fn;
		
	}
	
	@Override
	public List<FacultyNote> searchFacultyNotes()
	{
		String query1 = "select * from teachertable";
		List<FacultyNote> list = jdbcTemplate.query(query1,new FacultyNoteRowMapper());
		return list;
	}
	
	@Override
	public List<FacultyNote> searchDirectTable()
	{
		String query1 = "select * from directortable";
		List<FacultyNote> list = jdbcTemplate.query(query1,new FacultyNoteRowMapper());
		return list;
	}
	
	@Override
	public String addDirector(String fn_id) {
		FacultyDaoImpl fdao = new FacultyDaoImpl();
		FacultyNote fn = fdao.searchFacultyNote(fn_id);
//		System.out.println("retrived-------------"+fn.getFn_note());
//		String fnote= fn.getFn_note();
//		String status = fn.getFn_state();
				
		String query1 = "select * from teachertable where fn_id = '"+fn_id+"'";
		List<FacultyNote> list = jdbcTemplate.query(query1,new FacultyNoteRowMapper());
		if(!list.isEmpty()) {
//			System.out.println("retrived----------Not EMPTY---");
			String query2 = "insert into directortable values('"+fn.getFn_id()+"','"+fn.getFn_note()+"','"+fn.getFn_state()+"')";
			int rowCount = jdbcTemplate.update(query2);
			if(rowCount==1) {
				status="success";
//				System.out.println("retrived----------success---");
			}else {
//				System.out.println("retrived----------failure---");
				status = "failure";
			}
		}else {
//			System.out.println("retrived----------EMPTY---");
			
			status = "existed";
		}
		return status;
	}
	

	@Override
	public String deleteFromManager(String id){
		String query = "select * from teachertable where fn_id='"+id+"'";
		List<FacultyNote> std_List = jdbcTemplate.query(query, new FacultyNoteRowMapper());
		if(std_List.isEmpty()) {
			status="notexisted";
		}else {
			String query1 = "delete from teachertable where fn_id = '"+id+"'";
			int rowCount = jdbcTemplate.update(query1);
			if(rowCount==1) {
				status="success";
			}else {
				status="failure";
			}
		}
		
		return status;
	}

	@Override
	public String deleteFromDirector(String id){
		
		String query = "select * from directortable where fn_id='"+id+"'";
		List<FacultyNote> std_List = jdbcTemplate.query(query, new FacultyNoteRowMapper());
		if(std_List.isEmpty()) {
			status="notexisted";
		}else {
			String query1 = "delete from directortable where fn_id = '"+id+"'";
			int rowCount = jdbcTemplate.update(query1);
			if(rowCount==1) {
				status="success";
			}else {
				status="failure";
			}
		}
		
		return status;
	}

	@Override
	public String getStatus(String id)
	{
		 String query = "SELECT status FROM statustable WHERE fid = ?";		    
		 String status = jdbcTemplate.queryForObject(query, new Object[]{id}, String.class);
		    
		 return status;
	}
	
	@Override
	public void statusUpdate(String id,String status)
	{
	    String query = "UPDATE statustable SET status = ? WHERE fid = ?";
	    
	    int rowsAffected = jdbcTemplate.update(query, status, id);
	}
	
	@Override
	public void addAdmin(String date, String id, String state)
	{
		String query2 = "insert into admintable values('"+date+"','"+id+"','"+state+"')";
		int rowCount = jdbcTemplate.update(query2);
	}
	
	@Override 
	public List<Admin> searchAdmin() {
		String query1 = "select * from admintable";
		List<Admin> list = jdbcTemplate.query(query1,new AdminRowMapper());
		return list;
	}

}
