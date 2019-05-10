package com.cmpe202.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cmpe202.pojo.AddCard;
import com.cmpe202.pojo.Userprofile;
import com.cmpe202.service.AddCardService;

@RestController
@RequestMapping("/v1")
public class AddCardController {
	@Autowired
	private AddCardService addCardService;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@RequestMapping(value = "/GetCard", method = RequestMethod.GET)
	public List getAllUsers(HttpServletRequest request, Model model) {

		return addCardService.getAllUsers();
	}

	@RequestMapping(value = "/GetCard/{id}", method = RequestMethod.GET)
	public AddCard getUsers(@PathVariable String id) {
		return addCardService.getUsers(id);
	}

	@RequestMapping(value = "/PostCard/{emailid}", method = RequestMethod.POST)
	public void addUsers(@RequestBody AddCard addcard, @PathVariable String emailid) {
		Userprofile userprofilea = null;
		String SELECT_SQL = "SELECT * FROM Userprofile where emailid = ?";
		System.out.println("----------------------" + emailid);
		userprofilea = jdbcTemplate.queryForObject(SELECT_SQL, new UserMapper(), emailid);
		System.out.println("from query ------------  " + userprofilea.getEmailid());
		System.out.println("---------------IDDD:::" + userprofilea.getId());
		addcard.setUserid(userprofilea.getId());
		addCardService.addUsers(addcard);
	}

	@RequestMapping(value = "/ReloadCard/{id}", method = RequestMethod.PUT)
	public void updateUsers(@RequestBody AddCard user, @PathVariable int id) {
		//update statement
		
		addCardService.updateUsers(id, user);
	}

	@RequestMapping(value = "/DeleteCard/{id}", method = RequestMethod.DELETE)
	public void deleteUsers(@PathVariable String id) {
		//delete statement
		addCardService.deleteUsers(id);
	}

}
