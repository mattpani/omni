package sk.matt.entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;
import java.util.Set;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Table("person")
public class Person {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    @MappedCollection(idColumn = "person_id")
    private Set<Contact> contacts = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public Set<Contact> getContacts() {
        return contacts;
    }

    public void addContacts(Contact contact) {
        this.contacts.add(contact);
    }

}