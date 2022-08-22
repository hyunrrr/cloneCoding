package com.sokdak.cloneCoding.comment.dto;

import lombok.Getter;

@Getter
public class NewCommentRequest {

    private String content;

    public NewCommentRequest(String content) {
        this.content = content;
    }
}
