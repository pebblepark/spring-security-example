package com.spring.security.example.user.repo;

import com.spring.security.example.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserJpaRepo extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.uid= :uid")
    User loadUserByUsername(String uid);
}
