package com.github.abigail830.jwtdemo.api;

import com.github.abigail830.jwtdemo.application.AuditTrailApplService;
import com.github.abigail830.jwtdemo.domain.UserAuditTrail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    AuditTrailApplService auditTrailApplService;

    public List<UserAuditTrail> getAllAuditTrailHistory() {
        return auditTrailApplService.getAllAuditTrailRecord();
    }
}
