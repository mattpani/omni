package sk.matt.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import sk.matt.dao.ContactDao;
import sk.matt.dao.OrganizationDao;
import sk.matt.dao.PersonDao;
import sk.matt.entity.Contact;
import sk.matt.entity.Organization;
import sk.matt.entity.Person;
import sk.matt.services.OrganizationService;

import java.util.List;

@Service
@Qualifier("primaryOrganizationServiceImpl")
public class OrganizationServiceImpl implements OrganizationService {


    @Autowired
    private OrganizationDao primaryOrganizationDao;

    @Autowired
    private ContactDao primaryContactDao;


    @Override
    public Organization getOrganizationByName(Organization org) {
        return (Organization) primaryOrganizationDao.getOrganizationByName(org.getName());
    }

    @Override
    public List<Organization> getAllOrganizations() {
        return primaryOrganizationDao.getAllOrganizations();
    }

    @Override
    public Organization updateOrganization(Organization org) {
        Organization existingOrg = primaryOrganizationDao.findOrganizationById(org.getId());

        if (org.getName() != null) {
            existingOrg.setName(org.getName());
        }
        if (org.getContact() != null) {
            existingOrg.setContact(org.getContact());
        }

        return primaryOrganizationDao.saveOrganization(existingOrg);
    }

    @Override
    public Organization createdOrganization(Organization org) {
        return primaryOrganizationDao.saveOrganization(org);
    }

    @Override
    public Organization addContact(Organization org) {
        Organization existingOrg = primaryOrganizationDao.findOrganizationById(org.getId());
        if (existingOrg == null) {
            throw new IllegalArgumentException("Organization not found");
        }
        Contact contact = org.getContact();
        existingOrg.setContact(contact);
        return primaryOrganizationDao.saveOrganization(existingOrg);
    }

}
