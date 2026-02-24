package com.back.domain.post.entity;

import com.back.domain.member.entity.Member;
import com.back.global.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@NoArgsConstructor
@Setter
@Getter
public class Post extends BaseEntity {

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @ManyToOne
    private Member author;

    public Post(Member author, String title, String content) {
        this.author=author;
        this.title = title;
        this.content = content;
    }
}