package sk.matt.dao;

import sk.matt.entity.Contact;

import java.util.List;


public interface  ContactDao {
    List<Contact> getAllContacts();
    Contact saveContact(Contact contact);
    Contact findContactById(Long id);
    void deleteContactById(Long id);
}