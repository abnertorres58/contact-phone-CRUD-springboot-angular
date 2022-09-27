package com.freudromero.springboot.cruddemo.service;

import com.freudromero.springboot.cruddemo.dao.ContactDAO;
import com.freudromero.springboot.cruddemo.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{

    private ContactDAO contactDAO;

    @Autowired
    public ContactServiceImpl(ContactDAO theContactDAO) {
        contactDAO = theContactDAO;
    }

    @Override
    @Transactional
    public List<Contact> findAll() {
        return contactDAO.findAll();
    }

    @Override
    @Transactional
    public Contact findById(int theId) {
        return contactDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Contact theContact) {
        contactDAO.save(theContact);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        contactDAO.deleteById(theId);
    }
}
