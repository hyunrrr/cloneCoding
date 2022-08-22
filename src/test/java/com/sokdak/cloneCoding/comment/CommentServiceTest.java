package com.sokdak.cloneCoding.comment;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.sokdak.cloneCoding.comment.dto.NewCommentRequest;
import com.sokdak.cloneCoding.post.Post;
import com.sokdak.cloneCoding.post.PostRepository;
import com.sokdak.cloneCoding.post.exception.PostNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommentServiceTest {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    Post post;
    NewCommentRequest newCommentRequest = new NewCommentRequest("본문");

    @BeforeEach
    void setUp() {
        post = new Post("free", "제목", "본문");
        postRepository.save(post);
    }

    @DisplayName("comment를 추가한다.")
    @Test
    void addComment() {
        Long commentId = commentService.addComment(post.getId(), newCommentRequest);

        Comment comment = commentRepository.findById(commentId).get();

        assertThat(comment.getContent()).isEqualTo(comment.getContent());
    }

    @DisplayName("잘못된 postId에 댓글을 추가하면 예외가 발생한다.")
    @Test
    void addComment_Exception_NotFoundPost() {
        assertThatThrownBy(() -> commentService.addComment(9999L, newCommentRequest))
                .isInstanceOf(PostNotFoundException.class);
    }
}
