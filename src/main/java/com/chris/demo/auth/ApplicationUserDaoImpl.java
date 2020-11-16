package com.chris.demo.auth;

import com.chris.demo.entities.Account;
import com.chris.demo.entities.Authority;
import com.chris.demo.entities.User;
import com.chris.demo.repositories.AccountRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static com.chris.demo.security.ApplicationUserRole.*;

@Repository()
public class ApplicationUserDaoImpl implements ApplicationUserDao {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Optional<UserDetails> getApplicationUserByName(String username) {
         Account account = accountRepository.findByUsername(username);

         UserDetails userDetails = new ApplicationUser(
                 account.getUsername(),
                 account.getEncodedPassword(),
                 generateGrantedAuthority(account.getAuthorities()),
                 true,
                 true,
                 true,
                 true

         );
         return Optional.of(userDetails);
    }

    private Set<SimpleGrantedAuthority> generateGrantedAuthority(Set<Authority> authorities){
        Set<SimpleGrantedAuthority> permissions =  authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getPermission()))
                .collect(Collectors.toSet());
        return permissions;
    }



}
