package com.myProject.project.login.repositories;

import com.myProject.project.login.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long>{
    AppUser findByEmail(String email);
}
