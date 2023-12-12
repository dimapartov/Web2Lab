package com.example.websecondlab.services.impl.security;

import com.example.websecondlab.repositories.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

public class AppUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;
    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username)
                .map(u -> new User(
                        u.getUsername(),
                        u.getPassword(),
                        Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + u.getRole().getRole().name()))
                )).orElseThrow(() -> new UsernameNotFoundException(username + " was not found!"));
    }
}