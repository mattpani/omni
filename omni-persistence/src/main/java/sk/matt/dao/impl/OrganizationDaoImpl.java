package sk.matt.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.matt.dao.OrganizationDao;
import sk.matt.entity.Organization;
import sk.matt.repository.OrganizationRepository;

import java.util.List;

@Service
public class OrganizationDaoImpl implements OrganizationDao {

    private final OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationDaoImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public List<Organization> getAllOrganizations() {
        return (List<Organization>) organizationRepository.findAll();
    }

    @Override
    public Organization saveOrganization(Organization organization) {
        if (organization.getName() == null || organization.getName().isEmpty()) {
            throw new IllegalArgumentException("Organization name cannot be null or empty");
        }

        return organizationRepository.save(organization);
    }

    @Override
    public Organization findOrganizationById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        return organizationRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteOrganizationById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        organizationRepository.deleteById(id);
    }

}
