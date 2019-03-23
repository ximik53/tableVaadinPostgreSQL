package com.example.tableVaadinPostgreSQL;

public class Company {

    private Long id;
    public Long getId() {
        return id;
    }
    private String name;
    public String getName() {
        return name;
    }
    private String surname;
    public String getSurname() {
        return surname;
    }
    private String email;
    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
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