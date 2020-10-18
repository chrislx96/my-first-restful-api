package com.chris.demo.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

// Attention: using @Data here will cause dead loop.
@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id;
    @Column(name = "first_name", unique = false, nullable = false)
    private String firstName;
    @Column(name = "last_name", unique = false, nullable = false)
    private String lastName;
    @Column(name = "password", unique = false, nullable = false)
    private String password;
}
