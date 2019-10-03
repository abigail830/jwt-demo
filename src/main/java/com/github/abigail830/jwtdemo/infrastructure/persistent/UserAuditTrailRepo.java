package com.github.abigail830.jwtdemo.infrastructure.persistent;

import com.github.abigail830.jwtdemo.domain.UserAuditTrail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuditTrailRepo extends JpaRepository<UserAuditTrail, Long> {
//    UserAuditTrail findByUsername(String username);
}
