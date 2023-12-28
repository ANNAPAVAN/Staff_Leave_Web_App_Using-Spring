package com.pavan.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.pavan.dto.*;
import org.springframework.jdbc.core.RowMapper;

public class FacultyNoteRowMapper implements RowMapper<FacultyNote> {

	@Override
	public FacultyNote mapRow(ResultSet rs, int arg1) throws SQLException {
		FacultyNote fn = new FacultyNote();
		fn.setFn_id(rs.getString("fn_id"));
		fn.setFn_note(rs.getString("fn_note"));
		fn.setFn_state(rs.getString("fn_state"));
		
		return fn;
	}

}
