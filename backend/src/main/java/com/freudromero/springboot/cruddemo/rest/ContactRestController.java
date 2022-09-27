package com.freudromero.springboot.cruddemo.rest;

import com.freudromero.springboot.cruddemo.dao.ContactDAO;
import com.freudromero.springboot.cruddemo.entity.Contact;
import com.freudromero.springboot.cruddemo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    // add mapping for GET /contacts/{contactId}
    @GetMapping("/contacts/{contactId}")
    public Contact getContact(@PathVariable int contactId) {
        Contact theContact = contactService.findById(contactId);

        if(theContact == null) {
            throw new RuntimeException("Contact id not found - " + contactId);
        }

        return theContact;
    }

    // add mapping for POST /contacts - add new contact
    @PostMapping("/contacts")
    public Contact addContact(@RequestBody Contact theContact) {

        // also just in case they pass an id in JSON... set id to 0
        // this is to force a save of new item ... instead of update

        theContact.setId(0);

        contactService.save(theContact);

        return theContact;
    }

}
