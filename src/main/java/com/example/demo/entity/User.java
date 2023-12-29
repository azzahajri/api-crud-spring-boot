package com.example.demo.entity;

import jakarta.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="myuser")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="mail")
    private String email;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

}