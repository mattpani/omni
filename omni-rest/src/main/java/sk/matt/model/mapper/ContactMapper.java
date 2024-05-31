package sk.matt.model.mapper;

import org.mapstruct.Mapper;
import sk.matt.entity.Contact;
import sk.matt.model.ContactData;

@Mapper
public interface ContactMapper {
    ContactData dataToContact (Contact contact);
    Contact contactToData (ContactData contactData);
}
