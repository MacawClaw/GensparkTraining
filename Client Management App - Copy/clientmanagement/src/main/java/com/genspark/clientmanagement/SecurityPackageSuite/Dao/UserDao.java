package com.genspark.clientmanagement.SecurityPackageSuite.Dao;

import com.genspark.clientmanagement.SecurityPackageSuite.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
