package com.freudromero.springboot.cruddemo.rest;

import com.freudromero.springboot.cruddemo.dao.ContactDAO;
import com.freudromero.springboot.cruddemo.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContactRestController {

    private ContactDAO contactDAO;

    // quick and dirty: inject contact dao (will refactor later)(use constructor injection)
    @Autowired
    public ContactRestController(ContactDAO theContactDAO){
        contactDAO = theContactDAO;
    }

    // expose "/contacts" and return list of contacts
    @GetMapping("/contacts")
    public List<Contact> findAll() {
        return contactDAO.findAll();
    }

}
