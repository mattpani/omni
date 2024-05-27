package sk.matt;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import sk.matt.dao.impl.OrganizationDaoImpl;
import sk.matt.dao.impl.PersonDaoImpl;
import sk.matt.entity.Contact;
import sk.matt.entity.Organization;
import sk.matt.entity.Person;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RelationTest {

    @Autowired
    private PersonDaoImpl personService;

    @Autowired
    private OrganizationDaoImpl organizationService;

    @Test
    public void testRelationsAndDatabase() {
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");

        Contact contact = new Contact();
        contact.setAddress("123 Test St");
        person.addContacts(contact);

        Person savedPerson = personService.savePerson(person);

        Organization org = new Organization();
        org.setName("Test org");

        Contact contOrg = new Contact();
        contOrg.setAddress("123 Test Org");

        org.setContact(contOrg);
        assertNotNull(organizationService.saveOrganization(org));


        org.addPeople(person);
        assertNotNull(organizationService.saveOrganization(org));
        assertEquals(person, savedPerson);
    }

}
