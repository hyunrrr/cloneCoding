package com.sokdak.cloneCoding.post;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.sokdak.cloneCoding.post.dto.NewPostRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PostServiceTest {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @DisplayName("새로운 post 작성")
    @Test
    void addPost() {
        NewPostRequest newPostRequest = new NewPostRequest("free", "제목", "본문");
        Long postId = postService.addPost(newPostRequest);

        Post post = postRepository.findById(postId).get();

        assertAll(
                () -> assertThat(post.getTitle()).isEqualTo("제목"),
                () -> assertThat(post.getContent()).isEqualTo("본문")
        );
    }
}
