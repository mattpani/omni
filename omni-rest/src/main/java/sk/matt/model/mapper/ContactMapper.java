package sk.matt.model.mapper;

import org.mapstruct.Mapper;
import sk.matt.entity.Contact;
import sk.matt.model.ContactData;

import java.util.List;

@Mapper
public interface ContactMapper {
    ContactData dataToContact (Contact contact);
    Contact contactToData (ContactData contactData);

    List<ContactData> dataToContactList (List<Contact> contact);
    List<Contact> contactToDataList  (List<ContactData> contactData);
}
