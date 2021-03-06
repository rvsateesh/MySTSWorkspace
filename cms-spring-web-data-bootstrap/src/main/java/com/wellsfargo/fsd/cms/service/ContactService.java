package com.wellsfargo.fsd.cms.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.wellsfargo.fsd.cms.entity.Contact;
import com.wellsfargo.fsd.cms.exception.ContactException;

public interface ContactService {

	Contact add(Contact contact) throws ContactException;
	Contact save(Contact contact) throws ContactException;
	
	boolean deleteContact(int contactId) throws ContactException;
	
	Contact getContact(int contactId) throws ContactException;
	List<Contact> getAllContacts() throws ContactException;

	Contact findByMobile(String mobile);
	List<Contact> findAllByGroup(String group);
	List<Contact> findAllBornInRange(@DateTimeFormat(iso=ISO.DATE) LocalDate start,@DateTimeFormat(iso=ISO.DATE) LocalDate end);
	
}