package sk.matt.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;
import sk.matt.entity.relations.OrganizationPerson;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Table("organization")
public class Organization {

    @Id
    private Long id;
    private String name;
    @MappedCollection(idColumn = "organization_id")
    private Contact contact;
    @MappedCollection(idColumn = "person_id")
    private Set<OrganizationPerson> person = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Long> getPeopleIds() {
        return this.person.stream()
                .map(OrganizationPerson::getPersonId)
                .collect(Collectors.toSet());
    }

    public void addPeople(Person person) {
        this.person.add(new OrganizationPerson(person.getId(),this.id));
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}