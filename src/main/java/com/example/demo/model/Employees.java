package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Employees {

    @Id
    private Long SSN;
    private String username;
    private String password;
    private String name;
    private String surname;
    private Date birthdate;

    public Employees(Long SSN, String username, String password, String name, String surname, Date birthdate) {
        this.SSN = SSN;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
    }

    public Employees(){}


    public Long getSSN() {
        return SSN;
    }

    public void setSSN(Long SSN) {
        this.SSN = SSN;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}
