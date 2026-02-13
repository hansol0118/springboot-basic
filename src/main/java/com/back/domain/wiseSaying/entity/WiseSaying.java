package com.back.domain.wiseSaying.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class WiseSaying {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id; // Int
    @Column(length = 100,nullable = false)
    private String saying; // varchar(255)
    @Column(length = 50,nullable = false)
    private String author; // varchar(255)
}