package com.app.persona.bci.repository;

import com.app.persona.bci.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface IPersonaRepository extends JpaRepository<Person, Integer> {

    @Transactional(readOnly = true)
    Person findByemail(String mail);
}
