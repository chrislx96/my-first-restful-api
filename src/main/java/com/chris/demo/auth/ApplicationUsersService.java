package com.chris.demo.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.chris.demo.security.ApplicationUserRole.*;

@Service
public class ApplicationUsersService implements UserDetailsService {
    @Autowired
    private  ApplicationUserDao applicationUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return applicationUserDao
                .getApplicationUserByName(username)
                .orElseThrow(()->new UsernameNotFoundException((String.format("Username %s not found", username))));
    }

}
