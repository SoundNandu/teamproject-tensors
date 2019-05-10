package com.cmpe202.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cmpe202.service.OrderDetails;
@Repository
public interface IorderDetailsRepository extends CrudRepository <OrderDetails,String> {

}
