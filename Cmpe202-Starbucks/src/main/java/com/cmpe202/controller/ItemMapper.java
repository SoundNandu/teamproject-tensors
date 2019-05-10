package com.cmpe202.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cmpe202.pojo.ItemsDetails;
import com.cmpe202.pojo.itemtest;

public class ItemMapper  implements RowMapper<itemtest> {

	@Override
	public itemtest mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		itemtest itemdetails=new itemtest();
		
		itemdetails.setItemname(rs.getString("itemname"));
		itemdetails.setTotalamount(rs.getDouble("totalamount"));
		itemdetails.setItemsize(rs.getString("itemsize"));
		return itemdetails;
	}

}