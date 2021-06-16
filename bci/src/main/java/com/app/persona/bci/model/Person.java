package com.app.persona.bci.model;

import org.hibernate.annotations.Target;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;

@Entity
@Table(name = "PERSON")
public class Person {
    public Person() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPerson;

    @NotNull(message = "Los nombres no pueden ser nulos")
    @Size(min = 3, max = 70, message = "El nombre debe ser mayor a 3 caracteres")
    @Column(name = "name", length = 100, nullable = false,unique = false)
    private String name;

    @NotNull
    @Size(min = 10, message = "EL email debe ser al menos de 10 caracteres")
    @Email(message = "El email enviado no es un formato válido")
    @Column(name = "email", length = 100, nullable = false,unique = true)
    private String email;


    @Column(name = "password", length = 100, nullable = false,unique = false)
    private String password;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Phone phone;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = true)
    private Calendar created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified", nullable = true)
    private Calendar modified;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_login", nullable = true)
    private Calendar lastLogin;

    @NotNull(message = "Debe indicar si el usuario esta activo")
    @Column(name = "is_Active")
    private boolean isActive;

    @NotNull(message = "Debe introducir el token con el cual ingreso al servicio")
    @Column(name = "token", length = 1016)
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Calendar getCreated() {
        return created;
    }

    public void setCreated(Calendar created) {
        this.created = created;
    }

    public Calendar getModified() {
        return modified;
    }

    public void setModified(Calendar modified) {
        this.modified = modified;
    }

    public Calendar getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Calendar lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
