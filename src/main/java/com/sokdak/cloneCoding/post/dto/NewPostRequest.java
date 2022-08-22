package com.sokdak.cloneCoding.post.dto;

import lombok.Getter;

@Getter
public class NewPostRequest {

    private String type;
    private String title;
    private String content;

    public NewPostRequest(String type, String title, String content) {
        this.type = type;
        this.title = title;
        this.content = content;
    }
}
