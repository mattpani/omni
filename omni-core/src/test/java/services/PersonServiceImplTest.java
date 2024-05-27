package services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import sk.matt.entity.Contact;
import sk.matt.entity.Person;
import sk.matt.services.PersonService;
import sk.matt.services.impl.PersonServiceImpl;

public class PersonServiceImplTest {

    @InjectMocks
    private PersonServiceImpl primaryPersonServiceDao;

    @Test
    public void testGetPersonByFullName() {
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");

        PersonService mockService = mock(PersonServiceImpl.class);
        when(mockService.getPersonByFullName(person)).thenReturn(person);

        Person result = mockService.getPersonByFullName(person);
        assertEquals(person, result);
    }

    @Test
    public void testGetAllPerson() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person());
        persons.add(new Person());

        PersonService mockService = mock(PersonServiceImpl.class);
        when(mockService.getAllPerson()).thenReturn(persons);

        List<Person> result = mockService.getAllPerson();
        assertEquals(2, result.size());
    }

    @Test
    public void testUpdatePerson() {
        Person person = new Person();
        person.setId(1L);
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setDateOfBirth(LocalDate.of(1990, 5, 15));

        Person updatedPerson = new Person();
        updatedPerson.setId(1L);
        updatedPerson.setLastName("Smith");

        PersonService mockService = mock(PersonServiceImpl.class);
        when(mockService.updatePerson(updatedPerson)).thenReturn(updatedPerson);

        Person result = mockService.updatePerson(updatedPerson);
        assertEquals("Smith", result.getLastName());
    }

    @Test
    public void testCreatedPerson() {
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");

        PersonService mockService = mock(PersonServiceImpl.class);
        when(mockService.createdPerson(person)).thenReturn(person);

        Person result = mockService.createdPerson(person);
        assertEquals("John", result.getFirstName());
    }

    @Test
    public void testAddContact() {
        Person person = new Person();
        person.setId(1L);
        person.setFirstName("John");
        person.setLastName("Doe");
        person.addContacts(new Contact());
        person.addContacts(new Contact());

        PersonService mockService = mock(PersonServiceImpl.class);
        when(mockService.addContact(person)).thenReturn(person);

        Person result = mockService.addContact(person);
        assertEquals(2, result.getContacts().size());
    }
}

