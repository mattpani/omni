package sk.matt;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sk.matt.dao.OrganizationDao;
import sk.matt.entity.Organization;
import sk.matt.repository.OrganizationRepository;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OrganizationTest {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private OrganizationDao primaryOrganizationDao;

    @Test
    public void testGetAllOrganizations() {
        Organization org = new Organization();
        org.setName("Org");

        organizationRepository.save(org);
        assertNotNull(organizationRepository.save(org));
        List<Organization> organizations  = primaryOrganizationDao.getAllOrganizations();
        assertNotNull(organizations);
    }

    @Test
    public void testSaveOrganization() {
        Organization org = new Organization();
        org.setName("Org");

        Organization savedOrg = primaryOrganizationDao.saveOrganization(org);
        assertNotNull(savedOrg);
    }

    @Test
    public void testFindOrganizationById() {
        Organization org = new Organization();
        org.setName("Org");

        Organization savedOrg = organizationRepository.save(org);
        Organization foundOrg = primaryOrganizationDao.findOrganizationById(savedOrg.getId());
        assertEquals(savedOrg.getId(), foundOrg.getId());
    }

    @Test
    public void testDeleteOrganizationById() {
        Organization org = new Organization();
        org.setName("Org");

        Organization savedOrg = organizationRepository.save(org);
        primaryOrganizationDao.deleteOrganizationById(savedOrg.getId());
        assertFalse(organizationRepository.existsById(savedOrg.getId()));
    }

    @Test
    public void testGetOrganizationByName() {
        Organization org1 = new Organization();
        org1.setName("OrgName1"+ System.nanoTime());
        Organization org2 = new Organization();
        org2.setName("OrgName2");

        organizationRepository.save(org1);
        organizationRepository.save(org2);
        List<Organization> foundOrgs = primaryOrganizationDao.getOrganizationByName(org1.getName());
        assertEquals(1, foundOrgs.size());
        assertEquals(org1.getName(), foundOrgs.get(0).getName());
    }
}
