package com.cmpe202.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cmpe202.pojo.Userprofile;
import com.cmpe202.pojo.itemtest;
import com.cmpe202.service.OrderDetails;
import com.cmpe202.service.OrderDetailsService;

@RestController
@RequestMapping("/v1")
public class Ordercontroller {
	
	static int  order=1001;
	@Autowired
	private OrderDetailsService orderDetailsService;
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@RequestMapping(value = "/Postordertest/{emailid}", method = RequestMethod.POST)
	public void OrderDetails(@RequestBody OrderDetails Ordertest,@PathVariable String emailid) {
		Userprofile userprofilea = null;
		String SELECT_SQL_EMAIL = "SELECT * FROM Userprofile where emailid = ?";
		userprofilea = jdbcTemplate.queryForObject(SELECT_SQL_EMAIL, new UserMapper(), emailid);
		
		for (itemtest item : Ordertest.getItemtest1()) {
		
		
	//	orderDetailsService.addUsers(Ordertest);
		
			itemtest item1=null;
		
		
		Connection connection = null;
		String INSRT_SQL = "INSERT INTO OrderDetails (userid, orderid, itemname, itemsize, quantity, totalamount) VALUES (?, ?, ?, ?, ?, ?)";
		String SELECT_SQL = "SELECT * FROM itemtest where itemname ='" + Ordertest.getItemname() + "'&&itemsize='" + Ordertest.getItemsize() +"'";
		//item1=jdbcTemplate.queryForObject(SELECT_SQL, new ItemMapper());
		//double productquatityitemprice=item.getQuantity()*item1.getTotalamount();
		
		try{
		connection = jdbcTemplate.getDataSource().getConnection();
		PreparedStatement preparedstatement = connection.prepareStatement(INSRT_SQL);
		preparedstatement.setInt(1, userprofilea.getId());
		preparedstatement.setInt(2, order);
		preparedstatement.setString(3, item.getItemname());
		preparedstatement.setString(4,item.getItemsize());
		preparedstatement.setDouble(5, item.getQuantity());
		preparedstatement.setDouble(6, 145);
		preparedstatement.executeUpdate();
		preparedstatement.close();
		
		}
		
		catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {
            if (connection != null) {
                try {
                	connection.close();
                } catch (SQLException e) {}

            }
        }

	}
		System.out.println(order);
		order++;

	}
}

