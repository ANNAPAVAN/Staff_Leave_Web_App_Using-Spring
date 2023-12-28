package com.pavan.dao;

import java.util.List;

import com.pavan.dto.Admin;
import com.pavan.dto.Faculty;
import com.pavan.dto.FacultyNote;

public interface FacultyDao {
	public String addFaculty(Faculty fct);
	public Faculty search(String fid);
	public String addFacultyNote(FacultyNote fn);
	public FacultyNote searchFacultyNote(String fn_id);
	public List<FacultyNote> searchFacultyNotes();
	public String addDirector(String fid);
	public List<FacultyNote> searchDirectTable();
	
	public String deleteFromManager(String id);
	public String deleteFromDirector(String id);
	
	public String getStatus(String id);
	public void statusUpdate(String id,String status);
	
	public void addAdmin(String date, String id, String state);
	public List<Admin> searchAdmin();
	
}
