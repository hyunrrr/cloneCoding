package com.sokdak.cloneCoding.post;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private PostType type;

    private String title;

    private String content;

    protected Post() {
    }

    public Post(String type, String title, String content) {
        this.type = PostType.of(type);
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public Enum getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
