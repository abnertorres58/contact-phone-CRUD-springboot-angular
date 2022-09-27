package com.freudromero.springboot.cruddemo.rest;

import com.freudromero.springboot.cruddemo.dao.ContactDAO;
import com.freudromero.springboot.cruddemo.entity.Contact;
import com.freudromero.springboot.cruddemo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContactRestController {

    private ContactService contactService;
    @Autowired
    public ContactRestController(ContactService theContactService){
        contactService = theContactService;
    }

    // expose "/contacts" and return list of contacts
    @GetMapping("/contacts")
    public List<Contact> findAll() {
        return contactService.findAll();
    }

}
