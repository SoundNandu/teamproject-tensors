package com.cmpe202.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cmpe202.pojo.AddCard;
import com.cmpe202.pojo.PaymentDetails;
import com.cmpe202.pojo.Userprofile;
import com.cmpe202.service.PaymentService;


@RestController
@RequestMapping("/v1")
public class PaymentController {
	

	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@RequestMapping(value = "/Getpayment", method = RequestMethod.GET)
	public List getAllUsers() {
		return paymentService.getAllUsers();

	}

	@RequestMapping(value = "/Getpayment/{id}", method = RequestMethod.GET)
	public PaymentDetails getUsers(@PathVariable String id) {
		return paymentService.getUsers(id);
	}

	@RequestMapping(value = "/Postpayment/{emailid}", method = RequestMethod.POST)
	public void addUsers(@RequestBody PaymentDetails paymentDetails,@PathVariable String emailid) {
		Userprofile userprofilea = null;
		String SELECT_SQL_EMAIL = "SELECT * FROM Userprofile where emailid = ?";
		userprofilea = jdbcTemplate.queryForObject(SELECT_SQL_EMAIL, new UserMapper(), emailid);
		AddCard addCard=null;
		String SELECT_SQL = "SELECT * FROM CardDetails where userid =?";
		addCard=jdbcTemplate.queryForObject(SELECT_SQL, new CardMapper(),userprofilea.getId());
		paymentDetails.setCardNo(addCard.getCardNo());
		String SELECT_SQL_SUM =" SELECT SUM(totalamount ) FROM starbucks.OrderDetails where orderid in (select max(orderid) from starbucks.OrderDetails where userid='"+userprofilea.getId()+"') group by totalamount";
		double result = jdbcTemplate.queryForObject(SELECT_SQL_SUM, double.class);
		paymentDetails.setUserid(Integer.parseInt(userprofilea.getId()));
		double balanceToPay=addCard.getBalance()-result;
		paymentDetails.setAmounttotal(balanceToPay);
		paymentService.addUsers(paymentDetails);
	
	}



}
