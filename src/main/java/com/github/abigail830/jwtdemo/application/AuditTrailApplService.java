package com.github.abigail830.jwtdemo.application;

import com.github.abigail830.jwtdemo.domain.UserAuditTrail;
import com.github.abigail830.jwtdemo.infrastructure.persistent.UserAuditTrailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditTrailApplService {

    @Autowired
    UserAuditTrailRepo userAuditTrailRepo;

    public List<UserAuditTrail> getAllAuditTrailRecord() {
        return userAuditTrailRepo.findAll();
    }
}
