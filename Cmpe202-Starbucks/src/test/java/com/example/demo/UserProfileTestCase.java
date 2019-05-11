package com.example.demo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;



public class UserProfileTestCase {
	
	
	@InjectMocks

	UserprofileService userprofileService;
		
	@Mock
	private IuserprofileRepository iuserprofileRepository;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	



	@Test
	public void AddUserCardGet() {
		List<Userprofile> userprofile = new ArrayList<Userprofile>();
		userprofile.add(new Userprofile(1,"rajshree", "test", "test", "rajshre@gmail.com", "6692088787"));
		Mockito.when(iuserprofileRepository.findAll()).thenReturn(userprofile);
		List<AddCard> result = userprofileService.getAllUsers();
		assertEquals(1, result.size());
		
}
	@Test
	public void saveUser(){
		Userprofile userprofile = new Userprofile(1,"rajshree", "test", "test", "rajshre@gmail.com", "6692088787");
		when(iuserprofileRepository.save(userprofile)).thenReturn(userprofile);
		Userprofile result = userprofileService.addUsers(userprofile);
		assertEquals(1, result.getId());
		assertEquals("rajshree", result.getFirstname());
		assertEquals("test", result.getLastname());
		assertEquals("test", result.getPassword());
		assertEquals("rajshre@gmail.com", result.getEmailid());
		assertEquals("6692088787", result.getPhoneno());
}
	@Test
	public void removeUser(){
		Userprofile userprofile= new Userprofile(1,"rajshree", "test", "test", "rajshre@gmail.com", "6692088787");
		userprofileService.deleteUsers("1");
        verify(iuserprofileRepository, times(1)).deleteById("1");;
	}


}
