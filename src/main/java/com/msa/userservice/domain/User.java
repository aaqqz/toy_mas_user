package com.msa.userservice.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userId;

    private String email;
    private String name;
    private String password;
    private int activityScore = 0;

    @Builder
    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    // 활동 점수 적립
    public void addActivityScore(int score) {
        this.activityScore += score;
    }
}
