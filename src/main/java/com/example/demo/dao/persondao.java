package com.example.demo.dao;
import java.util.*;
import com.example.demo.model.person;
public interface persondao {
    int insertPerson(UUID id,person person);
    default int insertPerson(person person)
    {
        UUID id = UUID.randomUUID();
        return insertPerson(id,person);
    }
    List<person> selectAllPeople();
    Optional<person> selectPersonByID(UUID id);
    int deletePersonById(UUID id);
    int updatePersonById(UUID id,person person);

}
