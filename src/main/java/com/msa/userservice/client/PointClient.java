package com.msa.userservice.client;

import com.msa.userservice.dto.AddPointRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
public class PointClient {

    private final RestClient pointRestClient;

    public void addPoints(Long userId, int amount) {
        AddPointRequestDto addPointRequestDto = new AddPointRequestDto(userId, amount);

        pointRestClient.post()
                .uri("/points/add")
                .contentType(MediaType.APPLICATION_JSON)
                .body(addPointRequestDto)
                .retrieve()
                .toBodilessEntity();
    }
}
