package com.github.abigail830.jwtdemo.application;

import com.github.abigail830.jwtdemo.domain.ApplicationUser;
import com.github.abigail830.jwtdemo.infrastructure.persistent.ApplicationUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    ApplicationUserRepo applicationUserRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        final ApplicationUser user = applicationUserRepo.findByUsername(userName);
        if (user != null) {
            return new User(user.getUsername(), user.getPassword(), Collections.emptyList());
        } else {
            throw new UsernameNotFoundException(userName);
        }
    }
}
