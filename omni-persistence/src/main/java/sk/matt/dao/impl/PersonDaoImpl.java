package sk.matt.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import sk.matt.dao.PersonDao;
import sk.matt.entity.Person;
import sk.matt.repository.PersonRepository;

import java.util.List;
@Service
@Qualifier("primaryPersonDao")
public class PersonDaoImpl implements PersonDao {

    private final PersonRepository personRepository;

    @Autowired
    public PersonDaoImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getAllPersons() {

        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Person savePerson(Person person) {
        if (person.getFirstName() == null || person.getFirstName().isEmpty()
                || person.getLastName() == null || person.getLastName().isEmpty()) {
            throw new IllegalArgumentException("Person must have a first name");
        }
        return personRepository.save(person);
    }
    @Override
    public Person findPersonById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePersonById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        personRepository.deleteById(id);
    }

    @Override
    public List<Person> getPersonByFullName(Person person) {
        if (person.getFirstName() == null || person.getLastName() == null) {
            throw new IllegalArgumentException("Name iis");
        }
        return personRepository.findPersonByFullName(person.getFirstName(), person.getLastName());
    }

}