package com.reservation.reservation_server.serviceImpl.auth;

import com.reservation.reservation_server.common.RoleType;
import com.reservation.reservation_server.config.Security.JwtUtil;
import com.reservation.reservation_server.dto.CustomUserInfoDto;
import com.reservation.reservation_server.dto.LoginRequestDto;
import com.reservation.reservation_server.dto.StoreSignupRequestDto;
import com.reservation.reservation_server.entity.Store;
import com.reservation.reservation_server.entity.User;
import com.reservation.reservation_server.repository.StoreRepository;
import com.reservation.reservation_server.service.auth.StoreAuthService;
import jakarta.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class StoreAuthServiceImpl implements StoreAuthService {


    private final StoreRepository storeRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ModelMapper modelMapper;
    private final JwtUtil jwtUtil;

    @Autowired
    public StoreAuthServiceImpl(StoreRepository storeRepository, BCryptPasswordEncoder bCryptPasswordEncoder, ModelMapper modelMapper, JwtUtil jwtUtil) {
        this.storeRepository = storeRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.modelMapper = modelMapper;
        this.jwtUtil = jwtUtil;

    }


    @Transactional
    @Override
    public Store signup(StoreSignupRequestDto request) {

        if (storeRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }

        /**
         * 비밀번호 해시 처리
         * */

        Store store = Store.builder()
                .email(request.getEmail())
                .password(bCryptPasswordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .ownerName(request.getOwnerName())
                .phoneNumber(request.getPhoneNumber())
                .address(request.getAddress())
                .description(request.getDescription())
                .category(request.getCategory())
                .bizRegistrationNum(request.getBizRegistrationNum())
                .role(RoleType.STORE) // 기본 ROLE 지정
                .isActive(Boolean.TRUE)
                .build();


        return storeRepository.save(store);
    }

    @Transactional
    @Override
    public String login(LoginRequestDto request) {

        String email = request.getEmail();
        String password = request.getPassword();

        Store store = storeRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("이메일이 존재하지 않습니다"));

        if (!bCryptPasswordEncoder.matches(password, store.getPassword())) {
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다");
        }

        CustomUserInfoDto info = modelMapper.map(store, CustomUserInfoDto.class);

        return jwtUtil.createAccessToken(info);
    }

}
