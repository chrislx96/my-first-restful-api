package com.chris.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "movies")
public class Movie {

    //attributes
    @Id
    @GeneratedValue
    @Column(name = "movie_id")
    private Long id;

    @Column(name = "movie_name")
    private String name;

    @Column(name = "movie_length")
    private Long length;

    @Column(name = "movie_lang")
    private String language;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "age_certificate")
    private String ageCertificate;

    //attribute and relations
    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    private Director director;

    //relations
    @ManyToMany
    @JoinTable(name = "movies_actors",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private Set<Actor> actors;

    @OneToOne(mappedBy = "movie")
    private MovieRevenue movieRevenue;
}
