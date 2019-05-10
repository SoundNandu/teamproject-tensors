package com.cmpe202.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cmpe202.pojo.ItemsDetails;
import com.cmpe202.service.ItemsDetailsService;



@RestController
@RequestMapping("/v1")
public class ItemsDetailsController {
	
	@Autowired
	private ItemsDetailsService itemsDetailsService;

	@RequestMapping(value = "/Getitems", method = RequestMethod.GET)
	public List getAllUsers() {
		return itemsDetailsService.getAllUsers();

	}

	@RequestMapping(value = "/Getitems/{id}", method = RequestMethod.GET)
	public ItemsDetails getUsers(@PathVariable String id) {
		return itemsDetailsService.getUsers(id);
	}

	@RequestMapping(value = "/Postitems", method = RequestMethod.POST)
	public void addUsers(@RequestBody ItemsDetails item) {
	
		itemsDetailsService.addUsers(item);

	}

	@RequestMapping(value = "/Putitems/{id}", method = RequestMethod.PUT)
	public void updateUsers(@RequestBody ItemsDetails item, @PathVariable int id) {
		itemsDetailsService.updateUsers(id, item);
	}

	@RequestMapping(value = "/Deleteitems/{id}", method = RequestMethod.DELETE)
	public void deleteUsers(@PathVariable String id) {
		itemsDetailsService.deleteUsers(id);
	}
}
