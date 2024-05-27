package sk.matt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sk.matt.dao.PersonDao;
import sk.matt.entity.Person;
import sk.matt.repository.PersonRepository;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PersonTest {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonDao primaryPersonDao;

    @Test
    public void testGetAllPersons() {
        Person person1 = new Person();
        person1.setFirstName("Johns");
        person1.setLastName("Doe");
        assertNotNull(primaryPersonDao.savePerson(person1));
        List<Person> persons  = primaryPersonDao.getAllPersons();

        assertNotNull(persons);
    }

    @Test
    public void testSavePerson() {
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");

        Person savedPerson = primaryPersonDao.savePerson(person);
        assertEquals(person,savedPerson);
    }

    @Test
    public void testFindPersonById() {
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");
        Person savedPerson = personRepository.save(person);

        Person foundPerson = primaryPersonDao.findPersonById(savedPerson.getId());
        assertEquals(savedPerson.getId(), foundPerson.getId());
    }

    @Test
    public void testDeletePersonById() {
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");

        Person savedPerson = personRepository.save(person);
        assertEquals(person, savedPerson);

        primaryPersonDao.deletePersonById(savedPerson.getId());

        assertFalse(personRepository.existsById(savedPerson.getId()));
    }

    @Test
    public void testGetPersonByFullName() {
        Person person1 = new Person();
        person1.setFirstName("John");
        person1.setLastName("Doe");
        personRepository.save(person1);

        List<Person> foundPersons = primaryPersonDao.getPersonByFullName(person1);

        assertEquals("John", foundPersons.get(0).getFirstName());
        assertEquals("Doe", foundPersons.get(0).getLastName());
    }
}

