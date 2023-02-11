package com.example.demo.service;
import com.example.demo.model.person;
import com.example.demo.dao.persondao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class PersonService {
    private final persondao personDao;
    @Autowired
    public PersonService(@Qualifier("postgres") persondao persondao)
    {
        this.personDao=persondao;
    }
    public int addPerson(person person)
    {
return personDao.insertPerson(person);
    }
    public List<person> getAllPeople()
    {
        return personDao.selectAllPeople();
    }
    public Optional<person> getPersonById(UUID id)
    {
        return personDao.selectPersonByID(id);
    }
    public int deletePerson(UUID id)
    {
        return personDao.deletePersonById(id);
    }
    public int updatePerson(UUID id,person newPerson)
    {
        return personDao.updatePersonById(id,newPerson);
    }
}
