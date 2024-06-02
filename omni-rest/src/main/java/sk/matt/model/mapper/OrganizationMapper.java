package sk.matt.model.mapper;

import org.mapstruct.Mapper;
import sk.matt.entity.Organization;
import sk.matt.model.OrganizationData;

import java.util.List;

@Mapper
public interface OrganizationMapper {

    OrganizationData dataToOrganization (Organization organization);
    Organization organizationToData (OrganizationData organizationData);

    List<OrganizationData> dataToOrganizationList ( List<Organization> organization);
    List<Organization> organizationToDataList (List<OrganizationData> organizationData);
}
