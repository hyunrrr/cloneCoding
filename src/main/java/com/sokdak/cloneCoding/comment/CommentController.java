package com.sokdak.cloneCoding.comment;

import com.sokdak.cloneCoding.comment.dto.NewCommentRequest;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
@Transactional(readOnly = true)
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> addComment(@RequestParam(name = "id") Long postId,
                                           @RequestBody NewCommentRequest newCommentRequest) {
        Long commentId = commentService.addComment(postId, newCommentRequest);
        return ResponseEntity.created(URI.create("/comments/" + commentId)).build();
    }
}
