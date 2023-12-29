package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set; // Import the appropriate collection type

@Entity
@Table(name = "myclub")
@Getter
@Setter
public class Club {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(mappedBy = "clubs")
    private Set<Student> students;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ref;

    @Column(name = "creation_date")
    private String creationDate;
}
