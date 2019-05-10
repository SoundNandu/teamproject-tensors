package com.cmpe202.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmpe202.pojo.PaymentDetails;
import com.cmpe202.repo.IpaymentDetailsRepsitory;
@Service
public class PaymentService {
	
	@Autowired
	private IpaymentDetailsRepsitory paymentDetailsRepsitory;

	public List getAllUsers() {

		List users = new ArrayList<>();
		paymentDetailsRepsitory.findAll().forEach(users::add);
		return users;
	}

	public PaymentDetails getUsers(String firstname) {

		return paymentDetailsRepsitory.findById(firstname).orElse(null);

	}

	public PaymentDetails addUsers(PaymentDetails paymentDetails) {
		return paymentDetailsRepsitory.save(paymentDetails);
	}

	public void updateUsers(int id, PaymentDetails paymentDetails) {
		paymentDetailsRepsitory.save(paymentDetails);
	}

	public void deleteUsers(String id) {
		paymentDetailsRepsitory.deleteById(id);

	}

}
