package com.cmpe202.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cmpe202.pojo.ItemsDetails;
import com.cmpe202.pojo.itemtest;

@Repository
public interface IItemAddRepo  extends CrudRepository <itemtest,String>{

}
