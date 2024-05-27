package sk.matt.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sk.matt.entity.Organization;
import sk.matt.entity.Person;

import java.util.List;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Long> {

    @Query(  value = "SELECT * FROM organization ls where ls.name = :name")
    List<Organization> getOrganizationByName(@Param("name") String name);
}

