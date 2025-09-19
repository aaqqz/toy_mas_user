package com.msa.userservice.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AddPointRequestDto {

    private final Long userId;
    private final int amount;
}
