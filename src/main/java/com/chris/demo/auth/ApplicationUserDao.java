package com.chris.demo.auth;

import org.springframework.security.core.userdetails.UserDetails;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface ApplicationUserDao {
    Optional<UserDetails> getApplicationUserByName(String username);
}
