package com.freudromero.springboot.cruddemo.service;

import com.freudromero.springboot.cruddemo.entity.Contact;

import java.util.List;

public interface ContactService {

    public List<Contact> findAll();

    public Contact findById(int theId);

    public void save(Contact theContact);

    public void deleteById(int theId);
}
