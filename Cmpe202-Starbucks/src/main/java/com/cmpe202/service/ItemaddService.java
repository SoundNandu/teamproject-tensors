package com.cmpe202.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmpe202.pojo.ItemsDetails;
import com.cmpe202.pojo.itemtest;
import com.cmpe202.repo.IItemAddRepo;
import com.cmpe202.repo.IitemsDetailsRepository;
@Service
public class ItemaddService {
	@Autowired
	private IItemAddRepo iItemAddRepo;

	public List getAll() {

		List users = new ArrayList<>();
		iItemAddRepo.findAll().forEach(users::add);
		return users;
	}

	public itemtest getUsers(String firstname) {

		return iItemAddRepo.findById(firstname).orElse(null);

	}
}
