package sk.matt.model.mapper;

import org.mapstruct.Mapper;
import sk.matt.entity.Person;
import sk.matt.model.PersonData;

@Mapper
public interface PersonMapper {
    PersonData dataToPerson (Person person);
    Person personToData (PersonData personData);
}
