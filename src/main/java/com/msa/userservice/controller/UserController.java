package com.msa.userservice.controller;

import com.msa.userservice.dto.SignUpRequest;
import com.msa.userservice.dto.UserResponse;
import com.msa.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("sign-up")
    public ResponseEntity<Void> signUp(@RequestBody SignUpRequest signUpRequest) {
        userService.signUp(signUpRequest);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("{userId}")
    public ResponseEntity<UserResponse> get(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.get(userId));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getUsersByIds(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(userService.getUsersByIds(ids));
    }
}
