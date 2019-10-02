package com.github.abigail830.jwtdemo.application;

import com.github.abigail830.jwtdemo.domain.ApplicationUser;
import com.github.abigail830.jwtdemo.domain.UserAuditTrail;
import com.github.abigail830.jwtdemo.infrastructure.persistent.ApplicationUserRepo;
import com.github.abigail830.jwtdemo.infrastructure.persistent.UserAuditTrailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserApplService {

    @Autowired
    ApplicationUserRepo applicationUserRepo;

    @Autowired
    UserAuditTrailRepo userAuditTrailRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public void register(ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepo.save(user);
        userAuditTrailRepo.save(new UserAuditTrail(user.getUsername(), "REGISTER"));
    }

    public ApplicationUser findUserByName(String userName) {
        return applicationUserRepo.findByUsername(userName);
    }

    public void saveUserLoginInfo(ApplicationUser user) {
        userAuditTrailRepo.save(new UserAuditTrail(user.getUsername(), "LOGIN"));

    }
}
