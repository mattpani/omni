package sk.matt.entity.relations;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("organization_person")
public class OrganizationPerson {
    @Column("person_id")
    private Long personId;
    @Column("organization_id")
    private Long organizationId;

    public OrganizationPerson(Long personId,Long organizationId) {
        this.personId = personId;
        this.organizationId = organizationId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}
