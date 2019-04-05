package com.example.tableVaadinPostgreSQL;

import javax.persistence.*;

@Entity
public class Company {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
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