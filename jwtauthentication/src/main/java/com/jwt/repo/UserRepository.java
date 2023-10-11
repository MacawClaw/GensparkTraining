package com.jwt.repo;

import com.jwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //username , it will return the user of given username
    public User findByUsername(String username);
}
