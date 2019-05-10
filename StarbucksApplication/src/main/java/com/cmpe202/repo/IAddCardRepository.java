package com.cmpe202.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cmpe202.pojo.AddCard;
@Repository
public interface IAddCardRepository extends CrudRepository <AddCard,String> {

}
