package sk.matt.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import sk.matt.model.OrganizationData;

import javax.annotation.Generated;
import java.util.List;
import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-31T01:21:49.483040+02:00[Europe/Bratislava]", comments = "Generator version: 7.5.0")
@RestController
@RequestMapping("${openapi.sample.base-path:}")
public class OrganizationsApiController implements OrganizationsApi {

    private final NativeWebRequest request;

    @Autowired
    public OrganizationsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<List<OrganizationData>> organizationsGet() {
        return OrganizationsApi.super.organizationsGet();
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
