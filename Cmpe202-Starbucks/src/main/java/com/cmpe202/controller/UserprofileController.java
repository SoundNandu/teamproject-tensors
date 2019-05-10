package com.cmpe202.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cmpe202.pojo.AddCard;
import com.cmpe202.pojo.Userprofile;
import com.cmpe202.repo.IuserprofileRepository;
import com.cmpe202.service.UserprofileService;

@RestController
@RequestMapping("/v1")
public class UserprofileController {

	@Autowired
	private UserprofileService userService;
	@Autowired
	JdbcTemplate jdbcTemplate;

	@RequestMapping(value = "/login/{username}/{password}", method = RequestMethod.GET)
	public List login(@PathVariable String username, @PathVariable String password) {
		return userService.login(username,password);
		
	}

	@RequestMapping(value = "/Getuser", method = RequestMethod.GET)
	public List getAllUsers() {
		return userService.getAllUsers();

	}

	@RequestMapping(value = "/Getuser/{id}", method = RequestMethod.GET)
	public Userprofile getUsers(@PathVariable String id) {
		return userService.getUsers(id);
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public void addUsers(@RequestBody Userprofile user) {
		userService.addUsers(user);

	}

	@RequestMapping(value = "/Putuser/{emailid}", method = RequestMethod.PUT)
	public void updateUsers(@RequestBody Userprofile user, @PathVariable String emailid) {
		Connection connection = null;
		try {

			String SELECT_SQL_UPDATE = "UPDATE Userprofile SET firstname = ?, lastname = ?, password=?,phoneno=? WHERE emailid = ? ";
			connection = jdbcTemplate.getDataSource().getConnection();
			PreparedStatement preparedstatement = connection.prepareStatement(SELECT_SQL_UPDATE);
			// set the preparedstatement parameters
			preparedstatement.setString(1, user.getFirstname());
			preparedstatement.setString(2, user.getLastname());
			preparedstatement.setString(3, user.getPassword());
			preparedstatement.setString(4, user.getPhoneno());
			preparedstatement.setString(5, user.getEmailid());
			preparedstatement.executeUpdate();
			preparedstatement.close();
		} catch (SQLException se) {
			// log the exception
			try {
				throw se;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	

	@RequestMapping(value = "/Deleteuser/{id}", method = RequestMethod.DELETE)
	public void deleteUsers(@PathVariable String id) {
		userService.deleteUsers(id);
	}
	
}
