package sk.matt.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.matt.dao.ContactDao;
import sk.matt.entity.Contact;
import sk.matt.repository.ContactRepository;

import java.util.List;

@Service
public class ContactDaoImpl implements ContactDao {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactDaoImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<Contact> getAllContacts() {
        return (List<Contact>) contactRepository.findAll();
    }

    @Override
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact findContactById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        return contactRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteContactById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        contactRepository.deleteById(id);
    }

}