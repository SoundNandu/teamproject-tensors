package com.cmpe202.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cmpe202.pojo.PaymentDetails;
@Repository
public interface IpaymentDetailsRepsitory extends CrudRepository <PaymentDetails,String>{

}
