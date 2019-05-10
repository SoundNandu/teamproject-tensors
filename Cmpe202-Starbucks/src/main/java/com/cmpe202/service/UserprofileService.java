package com.cmpe202.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
