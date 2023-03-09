package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping ("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping //tells spring that this method would be used as a post request
    public void addPerson(@RequestBody Person person)
    {
        personService.addPerson(person);
    }
    @GetMapping
    public List<Person> getAllPeople()
    {
        return personService.getAllPeople();
    }
    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id)
    {
        return personService.getPersonById(id)
                .orElse(null);
    }
    @DeleteMapping(path = "{id}")
    public void deletePerson(@PathVariable("id") UUID id)
    {
        personService.deletePerson(id);
    }
    @PutMapping(path = "{id}")
    public void updatePersonById(@PathVariable("id") UUID id, @RequestBody Person personToUpdate)
    {
        personService.updatePeron(id, personToUpdate);
    }
}
