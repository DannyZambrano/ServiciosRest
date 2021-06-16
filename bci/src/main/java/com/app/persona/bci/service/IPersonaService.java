package com.app.persona.bci.service;

import com.app.persona.bci.model.Person;

import java.util.List;
import java.util.Optional;

public interface IPersonaService {

    List<Person> findAll();

    Optional<Person> findById(Integer id);

    Person create(Person person);

    Person update(Person person);

    void delete(Integer id);

    Person findByMail(String mail);

}
