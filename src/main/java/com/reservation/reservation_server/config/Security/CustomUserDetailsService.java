package com.reservation.reservation_server.config.Security;

import com.reservation.reservation_server.entity.Store;
import com.reservation.reservation_server.entity.User;
import com.reservation.reservation_server.repository.StoreRepository;
import com.reservation.reservation_server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final StoreRepository storeRepository; // Store Repository 추가

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository,
                                    StoreRepository storeRepository) {
        this.userRepository = userRepository;
        this.storeRepository = storeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userOpt = userRepository.findByEmail(email);

        if (userOpt.isPresent()) {
            // User가 있으면 CustomUserDetails 생성 후 반환
            return new CustomUserDetails(userOpt.get());
        } else {
            Optional<Store> storeOpt = storeRepository.findByEmail(email);

            if (storeOpt.isPresent()) {
                // Store가 있으면 CustomStoreDetails 생성 후 반환
                return new CustomStoreDetails(storeOpt.get());
            } else {
                // User와 Store 모두 없으면 예외 발생
                throw new UsernameNotFoundException("User or Store not found");
            }
        }

    }


    public UserDetails loadUserById(Long id) {
        // ID 기반 인증
        Optional<User> userOpt = userRepository.findById(id);

        if (userOpt.isPresent()) {
            // User가 있으면 CustomUserDetails 객체로 반환
            return new CustomUserDetails(userOpt.get());
        } else {
            Optional<Store> storeOpt = storeRepository.findById(id);

            if (storeOpt.isPresent()) {
                // Store가 있으면 CustomStoreDetails 객체로 반환
                return new CustomStoreDetails(storeOpt.get());
            } else {
                // User와 Store 모두 없으면 예외 발생
                throw new UsernameNotFoundException("User or Store not found");
            }
        }

    }

    public UserDetails loadUserByIdAndRole(Long id, String role) {
        if ("Store".equalsIgnoreCase(role)) {
            return storeRepository.findById(id)
                    .map(CustomStoreDetails::new)
                    .orElseThrow(() -> new UsernameNotFoundException("Store not found"));
        } else { // USER
            return userRepository.findById(id)
                    .map(CustomUserDetails::new)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        }
    }

}




