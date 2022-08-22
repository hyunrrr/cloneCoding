package com.sokdak.cloneCoding.post;

import com.sokdak.cloneCoding.post.dto.NewPostRequest;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
@Transactional(readOnly = true)
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> addPost(@RequestBody NewPostRequest newPostRequest) {
        Long postId = postService.addPost(newPostRequest);
        return ResponseEntity.created(URI.create("/posts/" + postId)).build();
    }
}
