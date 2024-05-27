package services;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import sk.matt.entity.Contact;
import sk.matt.entity.Organization;
import sk.matt.services.impl.OrganizationServiceImpl;

public class OrganizationServiceImplTest {

    @InjectMocks
    private OrganizationServiceImpl primaryOrganizationServiceDao;


    @Test
    public void testGetOrganizationByName() {
        Organization org = new Organization();
        org.setName("TestOrg");

        OrganizationServiceImpl mockService = mock(OrganizationServiceImpl.class);
        when(mockService.getOrganizationByName(org)).thenReturn(org);

        Organization result = mockService.getOrganizationByName(org);
        assertEquals(org, result);
    }

    @Test
    public void testGetAllOrganizations() {
        List<Organization> organizations = new ArrayList<>();
        organizations.add(new Organization());
        organizations.add(new Organization());

        OrganizationServiceImpl mockService = mock(OrganizationServiceImpl.class);
        when(mockService.getAllOrganizations()).thenReturn(organizations);

        List<Organization> result = mockService.getAllOrganizations();
        assertEquals(2, result.size());
    }

    @Test
    public void testUpdateOrganization() {
        Organization org = new Organization();
        org.setId(1L);
        org.setName("OldOrg");

        Organization updatedOrg = new Organization();
        updatedOrg.setId(1L);
        updatedOrg.setName("NewOrg");

        OrganizationServiceImpl mockService = mock(OrganizationServiceImpl.class);
        when(mockService.updateOrganization(updatedOrg)).thenReturn(updatedOrg);

        Organization result = mockService.updateOrganization(updatedOrg);
        assertEquals("NewOrg", result.getName());
    }

    @Test
    public void testCreatedOrganization() {
        Organization org = new Organization();
        org.setName("TestOrg");

        OrganizationServiceImpl mockService = mock(OrganizationServiceImpl.class);
        when(mockService.createdOrganization(org)).thenReturn(org);

        Organization result = mockService.createdOrganization(org);
        assertEquals("TestOrg", result.getName());
    }

    @Test
    public void testAddContact() {
        Organization org = new Organization();
        org.setId(1L);
        org.setName("TestOrg");
        Contact contact = new Contact();
        contact.setEmail("test@example.com");
        org.setContact(contact);

        OrganizationServiceImpl mockService = mock(OrganizationServiceImpl.class);
        when(mockService.addContact(org)).thenReturn(org);

        Organization result = mockService.addContact(org);
        assertEquals("test@example.com", result.getContact().getEmail());
    }
}
