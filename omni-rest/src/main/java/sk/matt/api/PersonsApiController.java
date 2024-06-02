package sk.matt.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import sk.matt.model.PersonData;
import sk.matt.model.mapper.PersonMapperImpl;
import sk.matt.services.PersonService;

import javax.annotation.Generated;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-31T01:21:49.483040+02:00[Europe/Bratislava]", comments = "Generator version: 7.5.0")
@RestController
@RequestMapping("${openapi.sample.base-path:}")
public class PersonsApiController implements PersonsApi {

    private final PersonService primaryPersonServiceImpl;
    private final NativeWebRequest request;

    @Autowired
    public PersonsApiController(PersonService primaryPersonServiceImpl, NativeWebRequest request) {
        this.primaryPersonServiceImpl = primaryPersonServiceImpl;
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<List<PersonData>> personsGet() {
        return PersonsApi.super.personsGet();
    }

    @Override
    public ResponseEntity<Void> personsIdDelete(Integer id) {
        return PersonsApi.super.personsIdDelete(id);
    }

    @Override
    public ResponseEntity<PersonData> personsIdGet(Integer id) {
        return PersonsApi.super.personsIdGet(id);
    }

    @Override
    public ResponseEntity<PersonData> personsIdPut(Integer id, PersonData personData) {
        return PersonsApi.super.personsIdPut(id, personData);
    }

    @Override
    public ResponseEntity<PersonData> personsPost(PersonData personData) {
        PersonMapperImpl perMapper = new PersonMapperImpl();
        return new ResponseEntity<>(perMapper.dataToPerson(primaryPersonServiceImpl.createdPerson(perMapper.personToData(personData))), HttpStatus.ACCEPTED);
    }
}
