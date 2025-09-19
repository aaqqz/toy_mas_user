package com.msa.userservice.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SignUpRequest {

    private final String email;
    private final String name;
    private final String password;
}
