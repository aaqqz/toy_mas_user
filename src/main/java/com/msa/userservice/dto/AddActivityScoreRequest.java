package com.msa.userservice.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AddActivityScoreRequest {

    private final Long userId;
    private final int score;
}
