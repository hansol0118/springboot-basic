package com.back.domain.wiseSaying.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@RequiredArgsConstructor

public class Post {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id; // Int
    @Column(length = 100,nullable = false)
    private final String title; // varchar(255)
    @Column(columnDefinition = "TEXT", nullable = false)
    private final String content; // varchar(255)

    public Post() {
        this.title = "";
        this.content = "";
    }
}