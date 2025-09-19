package com.msa.userservice.service;

import com.msa.userservice.client.PointClient;
import com.msa.userservice.domain.User;
import com.msa.userservice.dto.AddActivityScoreRequest;
import com.msa.userservice.dto.SignUpRequest;
import com.msa.userservice.domain.UserRepository;
import com.msa.userservice.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PointClient pointClient;

    @Transactional
    public void signUp(SignUpRequest signUpRequest) {
        User savedUser = User.builder()
                .email(signUpRequest.getEmail())
                .name(signUpRequest.getName())
                .password(signUpRequest.getPassword())
                .build();

        userRepository.save(savedUser);

        pointClient.addPoints(savedUser.getUserId(), 1000);
    }

    public UserResponse get(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        return UserResponse.of(user);
    }

    public List<UserResponse> getUsersByIds(List<Long> ids) {
        List<User> users = userRepository.findAllById(ids);

        return users.stream()
                .map(UserResponse::of)
                .toList();
    }

    @Transactional
    public void addActivityScore(AddActivityScoreRequest addActivityScoreRequest) {
        User user = userRepository.findById(addActivityScoreRequest.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        user.addActivityScore(addActivityScoreRequest.getScore());
    }
}
