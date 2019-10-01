package com.github.abigail830.jwtdemo.infrastructure.persistent;

import com.github.abigail830.jwtdemo.domain.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepo extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
}
