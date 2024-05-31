package sk.matt.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * OrganizationData
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-31T01:21:49.483040+02:00[Europe/Bratislava]", comments = "Generator version: 7.5.0")
public class OrganizationData {

  private Long id;

  private String name;

  private ContactData contact;

  @Valid
  private List<@Valid PersonData> person = new ArrayList<>();

  public OrganizationData id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public OrganizationData name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  
  @Schema(name = "name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public OrganizationData contact(ContactData contact) {
    this.contact = contact;
    return this;
  }

  /**
   * Get contact
   * @return contact
  */
  @Valid 
  @Schema(name = "contact", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("contact")
  public ContactData getContact() {
    return contact;
  }

  public void setContact(ContactData contact) {
    this.contact = contact;
  }

  public OrganizationData person(List<@Valid PersonData> person) {
    this.person = person;
    return this;
  }

  public OrganizationData addPersonItem(PersonData personItem) {
    if (this.person == null) {
      this.person = new ArrayList<>();
    }
    this.person.add(personItem);
    return this;
  }

  /**
   * Get person
   * @return person
  */
  @Valid 
  @Schema(name = "person", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("person")
  public List<@Valid PersonData> getPerson() {
    return person;
  }

  public void setPerson(List<@Valid PersonData> person) {
    this.person = person;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrganizationData organizationData = (OrganizationData) o;
    return Objects.equals(this.id, organizationData.id) &&
        Objects.equals(this.name, organizationData.name) &&
        Objects.equals(this.contact, organizationData.contact) &&
        Objects.equals(this.person, organizationData.person);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, contact, person);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganizationData {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    contact: ").append(toIndentedString(contact)).append("\n");
    sb.append("    person: ").append(toIndentedString(person)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

