package com.cmpe202.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmpe202.pojo.AddCard;
import com.cmpe202.repo.IAddCardRepository;
@Service
public class AddCardService {

	@Autowired
	private IAddCardRepository addcardRepository;

	public List getAllUsers() {

		List users = new ArrayList<>();
		addcardRepository.findAll().forEach(users::add);
		return users;
	}

	public AddCard getUsers(String firstname) {
	
		return addcardRepository.findById(firstname).orElse(null);

	}

	public AddCard addUsers(AddCard addcard) {
		return addcardRepository.save(addcard);
	}

	public void updateUsers(int id, AddCard addcard) {
		addcardRepository.save(addcard);
	}

	public void deleteUsers(String id) {
		addcardRepository.deleteById(id);
		
	}
}
