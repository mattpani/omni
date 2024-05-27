package sk.matt.dao;

import sk.matt.entity.Person;

import java.util.List;

public interface  PersonDao {

    List<Person> getAllPersons();
    Person savePerson(Person person);

    Person findPersonById(Long id);

    void deletePersonById(Long id);

    List<Person> getPersonByFullName(Person person);
}