package com.chris.demo.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "directors")
public class Director {

    //attributes
    @Id
    @GeneratedValue
    @Column(name = "director_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "nationality")
    private String nationality;

    //relations
    //director is the name of the object defined in the Movie class
    @OneToMany(mappedBy = "director")
    private Set<Movie> movies;
}
