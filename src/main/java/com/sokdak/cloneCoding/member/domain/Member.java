package com.sokdak.cloneCoding.member.domain;

import com.sokdak.cloneCoding.post.Post;
import com.sokdak.cloneCoding.post.dto.NewPostRequest;

public interface Member {

    Post writePost(NewPostRequest newPostRequest);
}
