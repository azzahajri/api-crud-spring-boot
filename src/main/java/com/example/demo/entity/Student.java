package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "mystudent")
@Getter
@Setter
public class Student {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    @JsonIgnoreProperties("students")
    @ManyToMany
    @JoinTable(
            name = "student_club",
            joinColumns = @JoinColumn(name = "student_nsc"),
            inverseJoinColumns = @JoinColumn(name = "club_ref")
    )
    private Set<Club> clubs;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer nsc;

    @Column(name = "mail")
    private String email;
}