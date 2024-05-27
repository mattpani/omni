package sk.matt.dao;


import sk.matt.entity.Organization;
import sk.matt.entity.Person;

import java.util.List;

public interface  OrganizationDao {
    List<Organization> getAllOrganizations();
    Organization saveOrganization(Organization organization);
    Organization findOrganizationById(Long id);
    void deleteOrganizationById(Long id);
    List<Organization> getOrganizationByName(String name);

}
