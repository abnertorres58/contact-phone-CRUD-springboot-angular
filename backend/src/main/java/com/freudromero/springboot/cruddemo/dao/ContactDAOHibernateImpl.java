package com.freudromero.springboot.cruddemo.dao;

import com.freudromero.springboot.cruddemo.entity.Contact;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ContactDAOHibernateImpl implements ContactDAO {

    // Define field for entitymanager
    private EntityManager entityManager;

    // Set up constructor injection
    @Autowired
    public ContactDAOHibernateImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Contact> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Contact> theQuery = currentSession.createQuery("from Contact", Contact.class);

        // execute query and get result list
        List<Contact> contacts = theQuery.getResultList();

        // return the results
        return contacts;
    }

    @Override
    public Contact findById(int theId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // get the contact
        Contact theContact = currentSession.get(Contact.class, theId);

        // return the contact
        return theContact;
    }

    @Override
    public void save(Contact theContact) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // Save contact
        currentSession.saveOrUpdate(theContact);

    }

    @Override
    public void deleteById(int theId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // Delete object with primary key
        Query theQuery = currentSession.createQuery(
                "delete from Contact where id=:contactId"
        );
        theQuery.setParameter("contactId", theId);

        theQuery.executeUpdate();

    }
}
