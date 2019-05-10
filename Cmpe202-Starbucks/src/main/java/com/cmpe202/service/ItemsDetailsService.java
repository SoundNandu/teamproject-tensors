package com.cmpe202.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmpe202.pojo.ItemsDetails;
import com.cmpe202.repo.IitemsDetailsRepository;
@Service
public class ItemsDetailsService {
	@Autowired
	private IitemsDetailsRepository itemsDetailsRepository;

	public List getAllUsers() {

		List users = new ArrayList<>();
		itemsDetailsRepository.findAll().forEach(users::add);
		return users;
	}

	public ItemsDetails getUsers(String firstname) {

		return itemsDetailsRepository.findById(firstname).orElse(null);

	}

	public ItemsDetails addUsers(ItemsDetails itemdetail) {
		return itemsDetailsRepository.save(itemdetail);
	}

	public void updateUsers(int id, ItemsDetails itemdetail) {
		itemsDetailsRepository.save(itemdetail);
	}

	public void deleteUsers(String id) {
		itemsDetailsRepository.deleteById(id);

	}
}
