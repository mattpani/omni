/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.5.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package sk.matt.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;
import sk.matt.model.PersonData;

import javax.annotation.Generated;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-31T01:21:49.483040+02:00[Europe/Bratislava]", comments = "Generator version: 7.5.0")
@Validated
@Tag(name = "persons", description = "the persons API")
public interface PersonsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /persons : Get all persons
     *
     * @return A list of persons (status code 200)
     */
    @Operation(
        operationId = "personsGet",
        summary = "Get all persons",
        responses = {
            @ApiResponse(responseCode = "200", description = "A list of persons", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PersonData.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/persons",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<PersonData>> personsGet(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"dateOfBirth\" : \"2000-01-23\", \"id\" : 0, \"contacts\" : [ { \"phoneNumber\" : \"phoneNumber\", \"address\" : \"address\", \"email\" : \"email\" }, { \"phoneNumber\" : \"phoneNumber\", \"address\" : \"address\", \"email\" : \"email\" } ] }, { \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"dateOfBirth\" : \"2000-01-23\", \"id\" : 0, \"contacts\" : [ { \"phoneNumber\" : \"phoneNumber\", \"address\" : \"address\", \"email\" : \"email\" }, { \"phoneNumber\" : \"phoneNumber\", \"address\" : \"address\", \"email\" : \"email\" } ] } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /persons/{id} : Delete a person by ID
     *
     * @param id  (required)
     * @return Deleted person successfully (status code 204)
     *         or Person not found (status code 404)
     */
    @Operation(
        operationId = "personsIdDelete",
        summary = "Delete a person by ID",
        responses = {
            @ApiResponse(responseCode = "204", description = "Deleted person successfully"),
            @ApiResponse(responseCode = "404", description = "Person not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/persons/{id}"
    )
    
    default ResponseEntity<Void> personsIdDelete(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /persons/{id} : Get a person by ID
     *
     * @param id  (required)
     * @return A person was found (status code 200)
     *         or Person not found (status code 404)
     */
    @Operation(
        operationId = "personsIdGet",
        summary = "Get a person by ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "A person was found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = PersonData.class))
            }),
            @ApiResponse(responseCode = "404", description = "Person not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/persons/{id}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<PersonData> personsIdGet(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"dateOfBirth\" : \"2000-01-23\", \"id\" : 0, \"contacts\" : [ { \"phoneNumber\" : \"phoneNumber\", \"address\" : \"address\", \"email\" : \"email\" }, { \"phoneNumber\" : \"phoneNumber\", \"address\" : \"address\", \"email\" : \"email\" } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /persons/{id} : Update a person by ID
     *
     * @param id  (required)
     * @param personData  (required)
     * @return Updated person successfully (status code 200)
     *         or Person not found (status code 404)
     */
    @Operation(
        operationId = "personsIdPut",
        summary = "Update a person by ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "Updated person successfully", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = PersonData.class))
            }),
            @ApiResponse(responseCode = "404", description = "Person not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/persons/{id}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<PersonData> personsIdPut(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id,
        @Parameter(name = "PersonData", description = "", required = true) @Valid @RequestBody PersonData personData
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"dateOfBirth\" : \"2000-01-23\", \"id\" : 0, \"contacts\" : [ { \"phoneNumber\" : \"phoneNumber\", \"address\" : \"address\", \"email\" : \"email\" }, { \"phoneNumber\" : \"phoneNumber\", \"address\" : \"address\", \"email\" : \"email\" } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /persons : Create a person
     *
     * @param personData  (required)
     * @return Created person (status code 201)
     */
    @Operation(
        operationId = "personsPost",
        summary = "Create a person",
        responses = {
            @ApiResponse(responseCode = "201", description = "Created person", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = PersonData.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/persons",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<PersonData> personsPost(
        @Parameter(name = "PersonData", description = "", required = true) @Valid @RequestBody PersonData personData
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"dateOfBirth\" : \"2000-01-23\", \"id\" : 0, \"contacts\" : [ { \"phoneNumber\" : \"phoneNumber\", \"address\" : \"address\", \"email\" : \"email\" }, { \"phoneNumber\" : \"phoneNumber\", \"address\" : \"address\", \"email\" : \"email\" } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
