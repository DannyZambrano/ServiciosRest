package com.app.persona.bci.controller;

import com.app.persona.bci.exeption.ExceptionResponse;
import com.app.persona.bci.model.Person;
import com.app.persona.bci.model.User;
import com.app.persona.bci.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/persona")
public class PersonController {

    @Autowired
    private PersonaService servicePer;

    @GetMapping
    public ResponseEntity<List<Person>> findAll(){
        return ResponseEntity.ok(servicePer.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(
            @PathVariable("id") Integer id) {
        return servicePer.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping(path = "/create")
    public ResponseEntity<Person> create(@Valid @RequestBody Person person) {


        Person personaAux = servicePer.findByMail(person.getEmail());

        if (personaAux!=null){

            ExceptionResponse exceptionResponse = new ExceptionResponse(
                    Calendar.getInstance(),
                    "Ocurrió un error",
                    "El correo electronico ya fue registrado en la base de datos por favor validar"
            );

            return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
        }else {
            person.setLastLogin(Calendar.getInstance());
            person.setCreated(Calendar.getInstance());
            return new ResponseEntity(servicePer.create(person), HttpStatus.CREATED);
        }


    }

    @PutMapping(path = "/update")
    public ResponseEntity<Person> update(@Valid @RequestBody Person person) {

        person.setLastLogin(Calendar.getInstance());
        person.setModified(Calendar.getInstance());
        return servicePer.findById(person.getIdPerson())
                .map(c -> ResponseEntity.ok(servicePer.update(person)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("user")
    public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {

        String token = getJWTToken(username);
        User user = new User();
        user.setUser(username);
        user.setToken(token);
        return user;

    }

    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("bci")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }

}
