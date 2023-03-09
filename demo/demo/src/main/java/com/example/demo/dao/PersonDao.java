package com.example.demo.dao;
//defining our database
//
import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    //The insertPerson() allows as to insert a person with a given id
    int insertPerson(UUID id, Person person);

    //This addPerson() allows us to insert a person without an id
    default int insertPerson(Person person)
    {
        UUID id = UUID.randomUUID();//generate random id for users whose id is not given
        return insertPerson(id, person);
    }
    List<Person> selectAllPeople();//implemented in PersonDataAccess service

    Optional<Person> selectPersonById(UUID id);
    int deletePersonById(UUID id);
    int updatePersonById(UUID id, Person person);


}
