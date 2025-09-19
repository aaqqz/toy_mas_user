package com.msa.userservice.service;

import com.msa.userservice.domain.User;
import com.msa.userservice.dto.SignUpRequest;
import com.msa.userservice.domain.UserRepository;
import com.msa.userservice.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void signUp(SignUpRequest signUpRequest) {
        User user = User.builder()
                .email(signUpRequest.getEmail())
                .name(signUpRequest.getName())
                .password(signUpRequest.getPassword())
                .build();

        userRepository.save(user);
    }

    public UserResponse get(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        return UserResponse.of(user);
    }
}
