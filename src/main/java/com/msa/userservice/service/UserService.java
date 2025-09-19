package com.msa.userservice.service;

import com.msa.userservice.domain.User;
import com.msa.userservice.dto.SignUpRequest;
import com.msa.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void signUp(SignUpRequest signUpRequest) {
        User user = User.builder()
                .email(signUpRequest.getEmail())
                .name(signUpRequest.getName())
                .password(signUpRequest.getPassword())
                .build();

        userRepository.save(user);
    }
}
