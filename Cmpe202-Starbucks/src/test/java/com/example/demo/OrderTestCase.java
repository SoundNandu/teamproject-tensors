package com.example.demo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTestCase {
	
	
	
@InjectMocks
	
OrderDetailsService orderDetailsService;
		
	@Mock
	private IorderDetailsRepository iorderDetailsRepository;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void saveorder(){
		OrderDetails orderDetails = new OrderDetails("1",1, 1, "caffe latte","tall" , 2,6.67);
		when(iorderDetailsRepository.save(orderDetails)).thenReturn(orderDetails);
		OrderDetails result = orderDetailsService.addUsers(orderDetails);
		assertEquals("1", result.getId());
		assertEquals(1, result.getOrderid());
		assertEquals(1, result.getUserid());
		assertEquals("caffe latte", result.getItemname());
		assertEquals("tall", result.getItemsize());
		assertEquals(2, result.getQuantity());
		
}

	
	

}
