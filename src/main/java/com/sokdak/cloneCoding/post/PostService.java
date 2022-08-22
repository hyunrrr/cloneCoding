package com.sokdak.cloneCoding.post;

import com.sokdak.cloneCoding.member.domain.Member;
import com.sokdak.cloneCoding.member.domain.User;
import com.sokdak.cloneCoding.post.dto.NewPostRequest;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Long addPost(NewPostRequest newPostRequest) {
        Member member = new User();
        Post post = member.writePost(newPostRequest);
        postRepository.save(post);
        return post.getId();
    }
}
