package sk.matt.services;

import sk.matt.entity.Organization;
import sk.matt.entity.Person;

import java.util.List;

public interface OrganizationService {


    Organization getOrganizationByName(Organization org);
    List<Organization> getAllOrganizations();

    Organization updateOrganization(Organization org);
    Organization createdOrganization(Organization org);

    Organization addContact(Organization org);
}
