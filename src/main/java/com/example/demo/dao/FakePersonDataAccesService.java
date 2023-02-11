package com.example.demo.dao;
import java.util.*;
import com.example.demo.model.person;
import org.springframework.stereotype.Repository;

@Repository("fakedao")
public class FakePersonDataAccesService implements persondao {
    private static List<person> db = new ArrayList<>();
    @Override
    public int insertPerson(UUID id,person person)
    {
        db.add(new person(id,person.getname()));
        return 1;
    }

    @Override
    public List<person> selectAllPeople() {
        return db;
    }

    @Override
    public Optional<person> selectPersonByID(UUID id) {
        return db.stream().filter(person->person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<person> personMaybe=selectPersonByID(id);
        if(personMaybe.isEmpty())
        return 0;
        db.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, person update) {
        return selectPersonByID(id).map(person -> {
            int indexOfPersonToUpdate=db.indexOf(person);
            if(indexOfPersonToUpdate>=0)
            {
                db.set(indexOfPersonToUpdate,new person(id,update.getname()));
                return 1;
            }
            return 0;
        } )
                .orElse(0);
    }
}
