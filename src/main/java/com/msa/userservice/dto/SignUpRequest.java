package com.msa.userservice.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class SignUpRequest {

    String email;
    String name;
    String password;
}
