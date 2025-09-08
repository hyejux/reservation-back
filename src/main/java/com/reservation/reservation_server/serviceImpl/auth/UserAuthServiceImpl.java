package com.reservation.reservation_server.serviceImpl.auth;

import com.reservation.reservation_server.config.Security.JwtUtil;
import com.reservation.reservation_server.dto.CustomUserInfoDto;
import com.reservation.reservation_server.dto.LoginRequestDto;
import com.reservation.reservation_server.dto.SigupRequestDto;
import com.reservation.reservation_server.entity.User;
import com.reservation.reservation_server.repository.UserRepository;
import com.reservation.reservation_server.service.auth.UserAuthService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserAuthServiceImpl implements UserAuthService {


    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ModelMapper modelMapper;
    private final JwtUtil jwtUtil;

    @Autowired
    public UserAuthServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, ModelMapper modelMapper, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.modelMapper = modelMapper;
        this.jwtUtil = jwtUtil;
    }


    @Transactional
    @Override
    public User signup(SigupRequestDto request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }

        /**
         * 비밀번호 해시 처리
         * */

        User user = User.builder()
                        .email(request.getEmail())
                        .password(bCryptPasswordEncoder.encode(request.getPassword()))
                        .name(request.getName())
                        .phoneNumber(request.getPhoneNumber())
                        .role(request.getRole())
                        .build();

        return userRepository.save(user);
    }

    @Transactional
    @Override
    public String login(LoginRequestDto request) {

        String email = request.getEmail();
        String password = request.getPassword();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("이메일이 존재하지 않습니다"));

        if (!bCryptPasswordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다");
        }

        CustomUserInfoDto info = modelMapper.map(user, CustomUserInfoDto.class);

        return jwtUtil.createAccessToken(info);
    }

}
