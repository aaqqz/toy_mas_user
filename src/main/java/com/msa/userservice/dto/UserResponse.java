package com.msa.userservice.dto;

import com.msa.userservice.domain.User;
import lombok.Getter;

@Getter
public class UserResponse {

    private final Long userId;
    private final String email;
    private final String name;

    private UserResponse(Long userId, String email, String name) {
        this.userId = userId;
        this.email = email;
        this.name = name;
    }

    public static UserResponse of(User user) {
        return new UserResponse(user.getUserId(), user.getEmail(), user.getName());
    }
}
