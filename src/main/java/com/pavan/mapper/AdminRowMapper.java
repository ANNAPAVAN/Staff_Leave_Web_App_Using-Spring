package com.pavan.mapper;

import com.pavan.dto.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AdminRowMapper implements RowMapper<Admin> {
	@Override
	public Admin mapRow(ResultSet rs, int arg1) throws SQLException {
		Admin ad = new Admin();
		ad.setDate(rs.getString("date"));
		ad.setId(rs.getString("id"));
		ad.setState(rs.getString("state"));
		return ad;
	}

}
