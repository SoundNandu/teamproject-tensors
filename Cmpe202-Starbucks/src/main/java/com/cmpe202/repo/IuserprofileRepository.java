package com.cmpe202.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cmpe202.pojo.Userprofile;
@Repository
public interface IuserprofileRepository extends CrudRepository <Userprofile,String> {
	Userprofile  findByEmailid(String emailid);
	
}
