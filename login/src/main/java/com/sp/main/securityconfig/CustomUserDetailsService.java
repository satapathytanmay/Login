package com.sp.main.securityconfig;

import com.sp.main.entity.User;
import com.sp.main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

        private final UserRepository userRepository;

        @Autowired
        public CustomUserDetailsService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        @Override
        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            User user = userRepository.findByEmail(email);
            if (user == null)
                throw new UsernameNotFoundException("User not found");
            return new CustomUserDetails(user);
        }
    }

