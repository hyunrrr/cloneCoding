package com.sokdak.cloneCoding.comment;

import com.sokdak.cloneCoding.comment.dto.NewCommentRequest;
import com.sokdak.cloneCoding.member.domain.Member;
import com.sokdak.cloneCoding.member.domain.User;
import com.sokdak.cloneCoding.post.Post;
import com.sokdak.cloneCoding.post.PostRepository;
import com.sokdak.cloneCoding.post.exception.PostNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository,
                          PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Transactional
    public Long addComment(Long postId, NewCommentRequest newCommentRequest) {
        Post post = postRepository.findById(postId)
                .orElseThrow(PostNotFoundException::new);
        Member member = new User();
        Comment comment = member.writeComment(newCommentRequest);
        commentRepository.save(comment);
        post.addComment(comment);
        return comment.getId();
    }
}
