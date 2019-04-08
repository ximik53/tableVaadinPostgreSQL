package com.example.tableVaadinPostgreSQL;

import javax.persistence.*;

@Table
@Entity

public class Company {

    @Id
    private long id;

    private String name;

    private String surname;

    private String email;

    public Company() {
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getSurame() {
        return this.surname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}