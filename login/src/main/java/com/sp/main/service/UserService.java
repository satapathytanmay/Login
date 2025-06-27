package com.sp.main.service;

import com.sp.main.entity.User;

public interface UserService

     {
        void save(User user);
        User findByEmail(String email);
    }

