package com.cmpe202.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cmpe202.pojo.Userprofile;
import com.cmpe202.repo.IuserprofileRepository;

@Service
public class UserprofileService {

	
	@Autowired
	private IuserprofileRepository userRepository;

	public List getAllUsers() {

		List users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	public Userprofile getUsers(String firstname) {
	
		return userRepository.findById(firstname).orElse(null);
		

	}

	public Userprofile addUsers(Userprofile user) {
		return userRepository.save(user);
	}

	public void updateUsers(int id, Userprofile user) {
		userRepository.save(user);
	}

	public void deleteUsers(String id) {
		userRepository.deleteById(id);	
	}
	
	
	
	public List login(String email,String password) {
		
		
		boolean result = false;
		List usersvalue = new ArrayList<>();
			String user =  "";
			String pass = "";
			System.out.println(user);
			System.out.println(pass);
			System.out.println(email);
			System.out.println(password);
			if((email.equals(userRepository.findByEmailid(email).getEmailid())) && (password.equals(userRepository.findByEmailid(email).getPassword()))) {
				System.out.println("login worked");
				user = userRepository.findByEmailid(email).getEmailid();
				usersvalue.add("succuess");
				result =  true;
			}else {
				System.out.println("login did not work");
				result = false;
				usersvalue.add("failed");
			}		
			
			return usersvalue;
		
		
	}
	
	
	
}
