package com.sp.main.repository;

import com.sp.main.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
        User findByEmail(String email);
    }


