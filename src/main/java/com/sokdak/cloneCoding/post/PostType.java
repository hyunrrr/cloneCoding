package com.sokdak.cloneCoding.post;

import com.sokdak.cloneCoding.post.exception.InvalidPostTypeException;
import java.util.Arrays;

public enum PostType {
    FREE("free");

    private final String value;

    PostType(String value) {
        this.value = value;
    }

    public static PostType of(String value) {
        return Arrays.stream(PostType.values())
                .filter(it -> it.getValue().equals(value))
                .findAny()
                .orElseThrow(InvalidPostTypeException::new);

    }

    private String getValue() {
        return value;
    }
}
