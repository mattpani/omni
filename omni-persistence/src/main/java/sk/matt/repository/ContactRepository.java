package sk.matt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.matt.entity.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
}
