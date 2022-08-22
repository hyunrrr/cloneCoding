package com.sokdak.cloneCoding.post;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.sokdak.cloneCoding.post.exception.InvalidPostTypeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PostTypeTest {

    @DisplayName("없는 type value로 조회하면 예외가 발생")
    @Test
    void of() {
        String invalidTypeValue = "invalid";

        assertThatThrownBy(() -> PostType.of(invalidTypeValue))
                .isInstanceOf(InvalidPostTypeException.class);
    }

}
