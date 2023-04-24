package com.example.projectsecurity.SecurityPackageSuite.Dao;

import com.example.projectsecurity.SecurityPackageSuite.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
