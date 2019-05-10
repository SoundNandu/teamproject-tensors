package com.cmpe202.controller;
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

import com.cmpe202.pojo.Userprofile;
import com.cmpe202.service.UserprofileService;

@RestController
@RequestMapping("/v1")
public class UserprofileController {

	@Autowired
	private UserprofileService userService;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(@RequestBody Userprofile userprofile, Model model, HttpSession session) {

		Userprofile userprofilea = null;
		List<Userprofile> userprofilelist = null;
		String emailid = userprofile.getEmailid();
		String Password = userprofile.getPassword();
		String DB_EmailId = "";
		String DB_Password = "";
		String FirstName = "";
		String LastName = "";
		int DB_UserID ;

		String SELECT_SQL = "SELECT * FROM Userprofile where emailid = ?";

		session.setAttribute("isLoggedIn", true);
		session.setAttribute("email", emailid);

		try {
			userprofilea = jdbcTemplate.queryForObject(SELECT_SQL, new UserMapper(), emailid);
			// userprofilea = jdbcTemplate.queryForObject(SELECT_SQL, new UserMapper());

		} catch (DataAccessException data) {
			data.printStackTrace();
		}

		if (userprofilea == null) {
			model.addAttribute("error", true);
			model.addAttribute("errorMessage", "UserNotAvailable");

		}

		DB_EmailId = userprofilea.getEmailid();
		DB_Password = userprofilea.getPassword();
		DB_UserID = userprofilea.getId();

		System.out.println("DB_Email::" + DB_EmailId);
		System.out.println("DB_Password::" + DB_Password);
		System.out.println("DB_UserID::" + DB_UserID);

		System.out.println("emailid::" + emailid);
		System.out.println("Password::" + Password);

		if (DB_EmailId.isEmpty() || DB_EmailId == null) {
			model.addAttribute("error", true);
			model.addAttribute("errorMessage", "UserNotAvailable");

		} else if (DB_EmailId.equals(emailid) && DB_Password.equals(Password)) {
			session.setAttribute("firstName", FirstName);
			session.setAttribute("userid", DB_UserID);
			session.setAttribute("lastName", LastName);
		} else {
			model.addAttribute("error", true);

		}

	}

	@RequestMapping(value = "/Getuser", method = RequestMethod.GET)
	public List getAllUsers() {
		return userService.getAllUsers();

	}

	@RequestMapping(value = "/Getuser/{id}", method = RequestMethod.GET)
	public Userprofile getUsers(@PathVariable String id) {
		return userService.getUsers(id);
	}

	@RequestMapping(value = "/Postuser", method = RequestMethod.POST)
	public void addUsers(@RequestBody Userprofile user) {
		userService.addUsers(user);

	}

	@RequestMapping(value = "/Putuser/{id}", method = RequestMethod.PUT)
	public void updateUsers(@RequestBody Userprofile user, @PathVariable int id) {
		userService.updateUsers(id, user);
	}

	@RequestMapping(value = "/Deleteuser/{id}", method = RequestMethod.DELETE)
	public void deleteUsers(@PathVariable String id) {
		userService.deleteUsers(id);
	}
	
	@RequestMapping(value = "/loginout", method = RequestMethod.POST)
	public void loginOut(@RequestBody Userprofile userprofile, Model model, HttpSession session) {

	}
	

}
