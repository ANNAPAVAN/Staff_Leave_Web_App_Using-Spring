package com.pavan.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pavan.dto.Faculty;

public class FacultyRowMapper implements RowMapper<Faculty> {
	@Override
	public Faculty mapRow(ResultSet rs, int arg1) throws SQLException {
		Faculty fct = new Faculty();
		fct.setFid(rs.getString("fid"));
		fct.setFname(rs.getString("fname"));
		fct.setFpwd(rs.getString("fpwd"));
		fct.setFemail(rs.getString("femail"));
		fct.setRole(rs.getString("role"));
		return fct;
	}
}
