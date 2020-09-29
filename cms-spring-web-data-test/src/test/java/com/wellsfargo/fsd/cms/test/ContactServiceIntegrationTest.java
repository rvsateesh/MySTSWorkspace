package com.wellsfargo.fsd.cms.test;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.wellsfargo.fsd.cms.dao.ContactRepository;
import com.wellsfargo.fsd.cms.entity.Contact;
import com.wellsfargo.fsd.cms.exception.ContactException;
import com.wellsfargo.fsd.cms.service.ContactService;

//@SpringJUnitConfig
@SpringBootTest
public class ContactServiceIntegrationTest {
	
	@Autowired
	private ContactRepository contactRepo;
	
	@Autowired
	private ContactService contactService;
	
	private Contact[] testData;

	@BeforeEach
	public void setUp() {
		testData = new Contact[] {
				new Contact(201, "person1",LocalDate.of(1990, Month.JUNE, 11),"9857412222","Helpers",true),
				new Contact(202, "person2",LocalDate.of(1990, Month.MAY, 11),"9857412111","Gym",true),
				new Contact(203, "person3",LocalDate.of(1990, Month.AUGUST, 11),"9857412355","Metro",false)
		};
		
		for(Contact c: testData) {
			contactRepo.saveAndFlush(c);
		}
	}
	
	@AfterEach
	public void tearDown() {
		
		contactRepo.deleteAll();
		testData=null;
	}
	
	@Test
	public void whenAdd_givenNewContact_shouldReturnThatContact() throws ContactException {
		Contact contact = new Contact(501, "test11",LocalDate.now(),"2077756789","testgrp",false);
		assertEquals(contactService.add(contact),contact);
	}
	
	@Test
	public void whenAdd_givenExistingContact_shouldReturnThatContact() throws ContactException {
		Contact contact = testData[0];
		assertThrows(ContactException.class,()->{contactService.add(contact);});
	}
}