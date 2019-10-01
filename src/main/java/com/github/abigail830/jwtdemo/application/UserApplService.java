package com.github.abigail830.jwtdemo.application;

import com.github.abigail830.jwtdemo.domain.ApplicationUser;
import com.github.abigail830.jwtdemo.infrastructure.persistent.ApplicationUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserApplService {

    @Autowired
    ApplicationUserRepo applicationUserRepo;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void saveUser(ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepo.save(user);
    }

    public ApplicationUser findUserByName(String userName) {
        return applicationUserRepo.findByUsername(userName);
    }
}
