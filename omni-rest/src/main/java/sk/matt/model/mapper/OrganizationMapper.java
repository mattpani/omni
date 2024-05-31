package sk.matt.model.mapper;

import org.mapstruct.Mapper;
import sk.matt.entity.Organization;
import sk.matt.model.OrganizationData;

@Mapper
public interface OrganizationMapper {

    OrganizationData dataToOrganization (Organization organization);
    Organization organizationToData (OrganizationData organizationData);
}
