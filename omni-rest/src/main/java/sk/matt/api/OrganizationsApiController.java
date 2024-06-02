package sk.matt.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import sk.matt.model.OrganizationData;
import sk.matt.model.mapper.OrganizationMapperImpl;
import sk.matt.services.OrganizationService;

import javax.annotation.Generated;
import java.util.List;
import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-31T01:21:49.483040+02:00[Europe/Bratislava]", comments = "Generator version: 7.5.0")
@RestController
@RequestMapping("${openapi.sample.base-path:}")
public class OrganizationsApiController implements OrganizationsApi {


    private final OrganizationService primaryOrganizationServiceImpl;
    private final NativeWebRequest request;

    @Autowired
    public OrganizationsApiController(OrganizationService primaryOrganizationServiceImpl, NativeWebRequest request) {
        this.primaryOrganizationServiceImpl = primaryOrganizationServiceImpl;
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<List<OrganizationData>> organizationsGet() {
        OrganizationMapperImpl orgMapper = new OrganizationMapperImpl();
        return new ResponseEntity<>(orgMapper.dataToOrganizationList(primaryOrganizationServiceImpl.getAllOrganizations()),HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<Void> organizationsIdDelete(Integer id) {
        return OrganizationsApi.super.organizationsIdDelete(id);
    }

    @Override
    public ResponseEntity<OrganizationData> organizationsIdGet(Integer id) {
        return OrganizationsApi.super.organizationsIdGet(id);
    }

    @Override
    public ResponseEntity<OrganizationData> organizationsIdPut(Integer id, OrganizationData organizationData) {
        return OrganizationsApi.super.organizationsIdPut(id, organizationData);
    }

    @Override
    public ResponseEntity<OrganizationData> organizationsPost(OrganizationData organizationData) {
        return OrganizationsApi.super.organizationsPost(organizationData);
    }
}
