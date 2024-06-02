package sk.matt.model.mapper;

import org.mapstruct.Mapper;
import sk.matt.entity.Person;
import sk.matt.model.PersonData;

import java.util.List;


@Mapper
public interface PersonMapper {
    PersonData dataToPerson (Person person);
    Person personToData (PersonData personData);

    List<PersonData> dataToPersonList (List<Person> person);
    List<Person> personToDataList (List<PersonData> personData);
}
