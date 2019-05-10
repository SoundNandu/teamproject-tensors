package com.cmpe202.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmpe202.repo.IorderDetailsRepository;
@Service
public class OrderDetailsService {
	
	
	
	@Autowired
	private IorderDetailsRepository orderDetailsRepository;

	public List getAllUsers() {

		List users = new ArrayList<>();
		orderDetailsRepository.findAll().forEach(users::add);
		return users;
	}
	
	
	public List getAllList() {

		List orderlist = new ArrayList<>();
		orderDetailsRepository.findAll().forEach(orderlist::add);
		return orderlist;
	}
	

	public OrderDetails getUsers(String firstname) {
	
		return orderDetailsRepository.findById(firstname).orElse(null);

	}

	public OrderDetails addUsers(OrderDetails orderDetails) {
		return orderDetailsRepository.save(orderDetails);
	}

	public void updateUsers(int id, OrderDetails orderDetails) {
		orderDetailsRepository.save(orderDetails);
	}

	public void deleteUsers(String id) {
		orderDetailsRepository.deleteById(id);
		
	}
	public Iterable<OrderDetails> list() {
	        return orderDetailsRepository.findAll();
	    }
	
	
	
}
