package com.github.abigail830.jwtdemo.application;

import com.github.abigail830.jwtdemo.domain.ApplicationUser;
import com.github.abigail830.jwtdemo.infrastructure.persistent.ApplicationUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    ApplicationUserRepo applicationUserRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        final ApplicationUser applicationUser = applicationUserRepo.findByUsername(userName);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(userName);
        }
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());

    }
}
