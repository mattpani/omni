package sk.matt.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sk.matt.entity.Person;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query(  value = "SELECT * FROM person ls where ls.first_name = :firstName and ls.Last_name = :lastName")
    List<Person> findPersonByFullName(@Param("firstName") String firstName,@Param("lastName") String lastName);
}