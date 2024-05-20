package sk.matt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.matt.entity.Organization;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Long> {
}

