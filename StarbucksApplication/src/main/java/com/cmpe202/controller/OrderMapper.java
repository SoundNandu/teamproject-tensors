package com.cmpe202.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cmpe202.pojo.Userprofile;
import com.cmpe202.service.OrderDetails;

public class OrderMapper  implements RowMapper<OrderDetails>{

	@Override
	public OrderDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		OrderDetails order=new OrderDetails();
		order.setItemname(rs.getString("itemname"));
		order.setItemsize(rs.getString("itemsize"));
		order.setQuantity(rs.getInt("quantity"));
		order.setTotalamount(rs.getDouble("totalamount"));
		return order;
	}

}
