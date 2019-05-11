package com.example.demo;

import static org.junit.Assert.assertEquals;
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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentTestCase {
	
@InjectMocks
	
PaymentService paymentService;
		
	@Mock
	private IpaymentDetailsRepsitory ipaymentDetailsRepsitory;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}

	
	@Test
	public void AddPaymentGet() {
		List<PaymentDetails> paymentDetails = new ArrayList<PaymentDetails>();
		paymentDetails.add(new PaymentDetails("1", 1, "999999", 89.0));
		Mockito.when(ipaymentDetailsRepsitory.findAll()).thenReturn(paymentDetails);
		List<AddCard> result = paymentService.getAllUsers();
		assertEquals(1, result.size());
		
}
	@Test
	public void savePayment (){
		PaymentDetails paymentDetails = new PaymentDetails("1", 1, "999999", 89.0);
		when(ipaymentDetailsRepsitory.save(paymentDetails)).thenReturn(paymentDetails);
		PaymentDetails result = paymentService.addUsers(paymentDetails);
		assertEquals("1", result.getId());
		assertEquals(1, result.getUserid());
		assertEquals("999999", result.getCardNo());
		
		
		
		
	}
	
	
	@Test
	public void removePayment(){
		PaymentDetails paymentDetails= new PaymentDetails("1", 1, "999999", 89.0);
		paymentService.deleteUsers("1");
        verify(ipaymentDetailsRepsitory, times(1)).deleteById("1");;
	}

}
