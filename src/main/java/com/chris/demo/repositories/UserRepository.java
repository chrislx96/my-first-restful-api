package com.chris.demo.repositories;

import com.chris.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    @Query("SELECT u FROM User u WHERE u.firstName=:firstName")
    public List<User> findUserByFirstName(@Param("firstName")String firstName);

    @Query("SELECT u FROM User u WHERE u.lastName=:lastName")
    public List<User> findUserByLastName(@Param("lastName")String lastName);
}
