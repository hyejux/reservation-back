package com.reservation.reservation_server.config.Security;

import com.reservation.reservation_server.dto.CustomUserInfoDto;
import com.reservation.reservation_server.entity.User;
import com.reservation.reservation_server.repository.UserRepository;
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
        System.out.println("작동된");
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new CustomUserDetails(user);
    }

    // ID 기반
    public UserDetails loadUserById(Long userId) {
        System.out.println("작동된");
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new CustomUserDetails(user);
    }




}

