package com.wellsfargo.fsd.cms.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.fsd.cms.entity.Contact;
import com.wellsfargo.fsd.cms.exception.ContactException;
import com.wellsfargo.fsd.cms.service.ContactService;
@RestController
@RequestMapping("/searchContacts")
public class SearchContactRestController {
    @Autowired
    private ContactService contactService;
    
    @GetMapping("/mobile/{mobile}")
    public ResponseEntity<List<Contact>> getbyMobile(@PathVariable("mobile") String mobile) throws ContactException{
    	List<Contact> contact = new ArrayList<Contact>();
    	contact.add(contactService.findByMobile(mobile));
        return new ResponseEntity<List<Contact>>(contact, HttpStatus.OK);
    }
    
    @GetMapping("/group/{group}")
    public ResponseEntity<List<Contact>> getbyGroup(@PathVariable("group") String group) throws ContactException{
        ResponseEntity<List<Contact>> resp=null;
        
        List<Contact> contacts = contactService.findAllByGroup(group);
        
        if(contacts.isEmpty()) {
            resp = new ResponseEntity<List<Contact>>(HttpStatus.NOT_FOUND);
        }else {
            resp = new ResponseEntity<List<Contact>>(contacts, HttpStatus.OK);
        }
        return resp;
    }
    
    @GetMapping("/dob/{start, end}")
    public ResponseEntity<List<Contact>> getbyGroup(@PathVariable("start") String sdate, @PathVariable("end") String edate) throws ContactException{
    	LocalDate start = LocalDate.parse(sdate);
    	LocalDate end = LocalDate.parse(edate);
    	
    	ResponseEntity<List<Contact>> resp=null;
        
        List<Contact> contacts = contactService.findAllBornInRange(start, end);
        
        if(contacts.isEmpty()) {
            resp = new ResponseEntity<List<Contact>>(HttpStatus.NOT_FOUND);
        }else {
            resp = new ResponseEntity<List<Contact>>(contacts, HttpStatus.OK);
        }
        return resp;
    }
}
