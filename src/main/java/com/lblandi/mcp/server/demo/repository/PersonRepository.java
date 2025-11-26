package com.lblandi.mcp.server.demo.repository;

import com.lblandi.mcp.server.demo.model.JobPosition;
import com.lblandi.mcp.server.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepository {
    private final List<Person> persons;

    public PersonRepository() {
        this.persons = new ArrayList<>();
        populate();
    }

    /**
     * Retrieves all persons stored in the repository.
     *
     * @return a list of Person objects representing all persons in the repository
     */
    public List<Person> findAll() {
        return persons;
    }

    /**
     * Finds a person by their unique identifier in the repository.
     * Searches the list of stored Person objects and retrieves the first match.
     *
     * @param id the unique identifier of the person to be found
     * @return an Optional containing the found Person object if present, or an empty Optional if no match is found
     */
    public Optional<Person> findById(Long id) {
        return persons.stream().filter(p -> p.id().equals(id)).findFirst().or(Optional::empty);
    }

    /**
     * Populates the internal list of persons with a predefined set of Person objects.
     * Each Person object includes information such as first name, last name, age,
     * and their associated JobPosition details. This method initializes the list with
     * sample data to allow further operations on the repository.
     *
     * This method is intended to be used internally during the construction of the repository
     * to ensure that the list is initialized with data.
     */
    private void populate() {
        Person p1 = new Person(1L, "Leandro", "Blandi", 23, new JobPosition("Backend Dev", 2500f, 3));
        Person p2 = new Person(2L, "Nahuel", "Perez", 54, new JobPosition("QA Automation", 2100f, 1));
        Person p3 = new Person(3L, "Diego", "Sanchez", 34, new JobPosition("Tech Lead", 3200f, 6));
        persons.addAll(List.of(p1, p2, p3));
    }
}
