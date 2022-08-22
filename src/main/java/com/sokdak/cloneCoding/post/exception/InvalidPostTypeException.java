package com.sokdak.cloneCoding.post.exception;

public class InvalidPostTypeException extends RuntimeException {

    private static final String MESSAGE = "잘못된 post type 입니다.";

    public InvalidPostTypeException() {
        super(MESSAGE);
    }
}
