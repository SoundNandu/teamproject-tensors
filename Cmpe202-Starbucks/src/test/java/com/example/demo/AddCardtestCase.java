

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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest

public class AddCardtestCase {
	
	@InjectMocks
	
	AddCardService addCardService;
		
	@Mock
	private IAddCardRepository iAddCardRepository;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}

	
	@Test
	public void AddCardGet() {
		List<AddCard> addd = new ArrayList<AddCard>();
		addd.add(new AddCard("1","99999999", "888", 90.00, 1));
		Mockito.when(iAddCardRepository.findAll()).thenReturn(addd);
		List<AddCard> result = addCardService.getAllUsers();
		assertEquals(1, result.size());
		
}
	@Test
	public void saveCard(){
		AddCard addCard = new AddCard("1","99999999", "888", 90.00, 1);
		when(iAddCardRepository.save(addCard)).thenReturn(addCard);
		AddCard result = addCardService.addUsers(addCard);
		assertEquals("1", result.getId());
		assertEquals("99999999", result.getCardNo());
		assertEquals("888", result.getCodeNo());
		assertEquals(1, result.getUserid());
		
		
	}
	
	
	@Test
	public void removeCard(){
		AddCard addCard= new AddCard("1","99999999", "888", 90.00, 1);
		addCardService.deleteUsers("1");
        verify(iAddCardRepository, times(1)).deleteById("1");;
	}
	

}