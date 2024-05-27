package sk.matt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sk.matt.dao.ContactDao;
import sk.matt.entity.Contact;
import sk.matt.repository.ContactRepository;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class ContactTest {

    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private ContactDao primaryContactDao;

    @Test
    public void testSaveContact() {
        Contact contact = new Contact();
        contact.setAddress("123 Test St");

        Contact savedContact = primaryContactDao.saveContact(contact);
        assertEquals(savedContact, contact);
    }

    @Test
    public void testFindContactById() {
        Contact contact = new Contact();
        contact.setAddress("123 Test St");

        primaryContactDao.saveContact(contact);
        Contact foundContact = primaryContactDao.findContactById(contact.getId());
        assertEquals(foundContact.getId(), contact.getId());
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact();
        contact.setAddress("123 Test St");

        Contact savedOrg = primaryContactDao.saveContact(contact);
        primaryContactDao.deleteContactById(savedOrg.getId());
        assertFalse(contactRepository.existsById(contact.getId()));
    }
}
