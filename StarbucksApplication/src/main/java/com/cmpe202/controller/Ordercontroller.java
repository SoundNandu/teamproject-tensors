package com.cmpe202.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cmpe202.pojo.AddCard;
import com.cmpe202.pojo.PaymentDetails;
import com.cmpe202.pojo.Userprofile;
import com.cmpe202.pojo.itemtest;
import com.cmpe202.service.ItemaddService;
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
		Connection connection = null;
		itemtest item1=null;
		for (itemtest item : Ordertest.getItemtest1()) {
		
		
			
			System.out.println("--------Ordertest.getItemname()-------"+item.getItemname());
			
			
			System.out.println("--------Ordertest.getItemsize()-------"+item.getItemsize());
		
		
		String INSRT_SQL = "INSERT INTO OrderDetails (userid, orderid, itemname, itemsize, quantity, totalamount) VALUES (?, ?, ?, ?, ?, ?)";
		String SELECT_SQL = "SELECT * FROM itemtest where itemname ='" + item.getItemname() + "'and itemsize='" + item.getItemsize() +"'";
		item1=jdbcTemplate.queryForObject(SELECT_SQL, new ItemMapper());
		
		double productquatityitemprice=item.getQuantity()*item1.getTotalamount();
		System.out.println("----------------"+productquatityitemprice);
		
		try{
		connection = jdbcTemplate.getDataSource().getConnection();
		PreparedStatement preparedstatement = connection.prepareStatement(INSRT_SQL);
		preparedstatement.setString(1, userprofilea.getId());
		preparedstatement.setInt(2, order);
		preparedstatement.setString(3, item.getItemname());
		preparedstatement.setString(4,item.getItemsize());
		preparedstatement.setDouble(5, item.getQuantity());
		preparedstatement.setDouble(6, productquatityitemprice);
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
	
	
	
	
	@RequestMapping(value = "/GetOrder/{userid}/{orderid}", method = RequestMethod.GET)
	public List GetOrder(HttpServletRequest request, Model model,@PathVariable String userid,@PathVariable String orderid) {
		
		String SELECT_ORDER = "SELECT * FROM OrderDetails where userid ='" + userid + "'and orderid='" + orderid +"'";
		OrderDetails orderDetails=null;
		List ordervalue = new ArrayList<>();

		orderDetails=jdbcTemplate.queryForObject(SELECT_ORDER, new OrderMapper());
	
		
			ordervalue.add(orderDetails.getItemname());
			ordervalue.add(orderDetails.getItemsize());
			ordervalue.add(orderDetails.getQuantity());
			ordervalue.add(orderDetails.getTotalamount());
			
		
			
		
		
		
		return ordervalue;
	}

	
	
	@RequestMapping(value ="/GetOrder", method = RequestMethod.GET)
    public Iterable<OrderDetails> list() {
        return orderDetailsService.list();
    }
	


	@RequestMapping(value = "/Gets", method = RequestMethod.GET)
	public List getAllUsers() {
		return orderDetailsService.getAllUsers();

	}
	
	
}

