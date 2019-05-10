package com.cmpe202.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cmpe202.pojo.AddCard;


public class CardMapper implements RowMapper<AddCard> {

	@Override
	public AddCard mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		AddCard addcard = new AddCard();
		addcard.setCardNo(rs.getString("cardNo"));
		addcard.setBalance(rs.getDouble("balance"));
		return addcard;
	}

}