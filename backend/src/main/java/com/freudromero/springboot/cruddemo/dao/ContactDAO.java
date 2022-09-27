package com.freudromero.springboot.cruddemo.dao;

import com.freudromero.springboot.cruddemo.entity.Contact;

import java.util.List;

public interface ContactDAO {

    public List<Contact> findAll();

}
