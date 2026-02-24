package com.back.global;

import com.back.domain.member.service.MemberService;
import com.back.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;


@Configuration
@RequiredArgsConstructor
@Transactional(readOnly = true)

public class BaseInitData {

    @Autowired
    @Lazy
    private BaseInitData self;

    private final PostService postService;
    private final MemberService memberService;

    @Bean
    ApplicationRunner devinitData() {
        return args -> {

            self.work1();
            self.work2();
        };
    }

    @Transactional
    void work1() {

        if (postService.count() > 0) {
            return;
        }

        // 어떤 기능을 테스트 데이터가 2개인 것을 가정하고 개발
        postService.write("제목1", "내용1");

//        if (true) {
//            throw new RuntimeException("테스트 예외");
//        }

        postService.write("제목2", "내용2");
    }

    @Transactional
    void work2() {
        memberService.join("systemUser", "123","시스템");
        memberService.join("adminUser", "123","관리자");
        memberService.join("user1", "123","유저1");
        memberService.join("user2", "123","유저2");
        memberService.join("user3", "123","유저3");
    }
    }
