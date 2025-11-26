package com.lblandi.mcp.server.demo.service;

import com.lblandi.mcp.server.demo.model.Person;
import com.lblandi.mcp.server.demo.repository.PersonRepository;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl {
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Tool(name = "find_all_persons", description = "Finds all persons loaded in memory")
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Tool(name = "find_person_by_id", description = "Finds a person by ID")
    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }
}
