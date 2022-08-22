package com.sokdak.cloneCoding.post.exception;

public class PostNotFoundException extends RuntimeException {

    private static final String MESSAGE = "존재하지 않은 post id입니다.";

    public PostNotFoundException() {
        super(MESSAGE);
    }
}
