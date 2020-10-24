package com.chris.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "movie_revenues")
public class MovieRevenue {

    //attributes
    @Id
    @GeneratedValue
    @Column(name = "revenue_id")
    private Long id;

    @Column(name = "domestic_takings")
    private Float domesticTakings;

    @Column(name = "international_takings")
    private Float internationalTakings;

    //attribute and relations
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")
    private Movie movie;
}
