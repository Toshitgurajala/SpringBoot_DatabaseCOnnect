package com.example.demo.dao;

import com.example.demo.model.person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository("postgres")
public class PersonDataAccessService implements persondao{

    private final JdbcTemplate jdbcTemplate;
@Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public int insertPerson(UUID id, person person) {
        return 0;
    }

    @Override
    public List<person> selectAllPeople() {
        final String sql = "SELECT id,name FROM person";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            return new person(id, name);
        });

    }

    @Override
    public Optional<person> selectPersonByID(UUID id) {
        final String sql = "SELECT id, name FROM person WHERE id = ?";
        Object[] params = new Object[] { id };
        person person = jdbcTemplate.queryForObject(sql, params, (resultSet, i) ->
                new person(
                        UUID.fromString(resultSet.getString("id")),
                        resultSet.getString("name")
                )
        );

        return Optional.ofNullable(person);
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, person person) {
        return 0;
    }
}
