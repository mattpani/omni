package sk.matt.services;


import sk.matt.entity.Person;

import java.util.List;

public interface PersonService {

    Person getPersonByFullName(Person person);
    List<Person> getAllPerson();

    Person updatePerson(Person person);
    Person createdPerson(Person person);

    Person addContact(Person person);

}
