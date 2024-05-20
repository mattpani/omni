package sk.matt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.matt.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

}