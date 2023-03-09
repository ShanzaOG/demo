package com.example.demo.services;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired    //because we are injecting into the constructor.
    //Because we may have many  implementation of the Interface DAO we also add a qualifier
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {//adding a qualifier to distinguish
        this.personDao = personDao;//auto wiring our interface
    }

    //the method addPerson() adds new person
    public int addPerson(Person person)
    {
        return personDao.insertPerson(person);
    }
    public List<Person> getAllPeople()
    {
        return personDao.selectAllPeople();
    }
    public Optional<Person> getPersonById(UUID id)
    {
        return personDao.selectPersonById(id);
    }
    public int deletePerson(UUID id)
    {
        return personDao.deletePersonById(id);
    }
    public int updatePeron(UUID id, Person newPerson)
    {
        return personDao.updatePersonById(id, newPerson);
    }
}
// by this we have the option of providing the id or not.