package com.chris.demo.repositories;

import com.chris.demo.entities.Account;
import com.chris.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("select u from User u join fetch u.authorities a from u.username=:username")
    Account findByUsername(@Param("username") String username);
}
