package com.example.demo.api;
import  com.example.demo.model.person;
import  com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.*;
@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private PersonService personservice;
    @Autowired
    public PersonController(PersonService personService)
    {
        this.personservice=personService;
    }
    @PostMapping
    public void addPerson(@Valid @NonNull  @RequestBody person person)
    {
        personservice.addPerson(person);
    }
    @GetMapping
    public List<person> getAllPeople()
    {
        return personservice.getAllPeople();
    }
    @GetMapping(path="{id}")
    public person getPersonByID(@PathVariable("id") UUID id)
    {
             return personservice.getPersonById(id).orElse(null);
    }
    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id")UUID id)
    {
        personservice.deletePerson(id);
    }
    @PutMapping(path="{id}")
    public void updatePerson(@PathVariable("id") UUID id ,@Valid @NonNull  @RequestBody person personToUpdate)
    {
        personservice.updatePerson(id,personToUpdate);
    }
}
