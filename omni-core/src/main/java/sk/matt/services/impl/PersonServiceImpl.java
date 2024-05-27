package sk.matt.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import sk.matt.dao.PersonDao;
import sk.matt.entity.Person;
import sk.matt.entity.Contact;
import sk.matt.services.PersonService;

import java.util.List;

@Service
@Qualifier("primaryPersonServiceImpl")
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao primaryPersonDao;

    @Override
    public Person getPersonByFullName(Person person) {
        return (Person) primaryPersonDao.getPersonByFullName(person);
    }

    @Override
    public List<Person> getAllPerson() {
        return primaryPersonDao.getAllPersons();
    }

    @Override
    public Person updatePerson(Person person) {
        Person existingPerson = primaryPersonDao.findPersonById(person.getId());

        if (person.getLastName() != null) {
            existingPerson.setLastName(person.getLastName());
        }
        if (person.getFirstName() != null) {
            existingPerson.setFirstName(person.getFirstName());
        }
        if (person.getDateOfBirth() != null) {
            existingPerson.setDateOfBirth(person.getDateOfBirth());
        }

        return primaryPersonDao.savePerson(existingPerson);
    }

    @Override
    public Person createdPerson(Person person) {
        return primaryPersonDao.savePerson(person);
    }

    @Override
    public Person addContact(Person person) {
        Person existingPerson = primaryPersonDao.findPersonById(person.getId());
        if (existingPerson == null) {
            throw new IllegalArgumentException("Person not found");
        }
        for (Contact contact : person.getContacts()) {
            existingPerson.getContacts().add(contact);
        }
        return primaryPersonDao.savePerson(existingPerson);
    }
}