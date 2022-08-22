package com.sokdak.cloneCoding.member.domain;

import com.sokdak.cloneCoding.post.Post;
import com.sokdak.cloneCoding.post.dto.NewPostRequest;

public class User implements Member {

    @Override
    public Post writePost(NewPostRequest newPostRequest) {
        return new Post(newPostRequest.getType(),
                newPostRequest.getTitle(), newPostRequest.getContent());
    }
}
