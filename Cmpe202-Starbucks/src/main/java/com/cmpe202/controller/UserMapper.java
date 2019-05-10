package com.cmpe202.controller;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cmpe202.pojo.Userprofile;

public class UserMapper implements RowMapper<Userprofile> {

	@Override
	public Userprofile mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Userprofile user = new Userprofile();
		user.setId(rs.getInt("id"));
		user.setEmailid(rs.getString("emailid"));
		user.setPassword(rs.getString("password"));
		return user;
	}

}
