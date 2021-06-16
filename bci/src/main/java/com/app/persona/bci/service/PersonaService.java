package com.app.persona.bci.service;

import com.app.persona.bci.model.Person;
import com.app.persona.bci.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PersonaService implements IPersonaService{

    @Autowired
    private IPersonaRepository personaRepo;

    @Override
    public List<Person> findAll() {
        return personaRepo.findAll();
    }

    @Override
    public Optional<Person> findById(Integer id) {
        return personaRepo.findById(id);
    }

    @Override
    public Person create(Person person) {
        return personaRepo.save(person);
    }

    @Override
    public Person update(Person person) {
        return personaRepo.save(person);
    }

    @Override
    public void delete(Integer id) {
        personaRepo.deleteById(id);
    }

    @Override
    public Person findByMail(String mail) {

        return personaRepo.findByemail(mail);
    }


}
