package com.back.domain.post.repository;

import com.back.domain.member.entity.Member;
import com.back.domain.member.service.MemberService;
import com.back.domain.post.entity.Post;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class PostRepositoryTest {
    @Autowired
    private PostRepository postRepository;
    private MemberService memberService;


    @Test
    @DisplayName("2번 글 조회")
    void t1() {
        Post post1 = postRepository.findById(2).get();

        assertThat(post1.getId()).isEqualTo(2);
        assertThat(post1.getTitle()).isEqualTo("제목2");
        assertThat(post1.getContent()).isEqualTo("내용2");

    }

    @Test
    @DisplayName("글 생성")
    void t2() {
        Member author1= memberService.findById(3).get();
        Post post = new Post(author1,"제목3","내용3");
        Post savePost = postRepository.save(post);
        assertThat(post.getId()).isEqualTo(3);
        assertThat(post.getTitle()).isEqualTo("제목3");
        assertThat(post.getContent()).isEqualTo("내용3");

    }

    @Test
    @DisplayName("글 개수 조회")
    void t3() {
        long cnt = postRepository.count();
        assertThat(cnt).isEqualTo(2);
    }

}
