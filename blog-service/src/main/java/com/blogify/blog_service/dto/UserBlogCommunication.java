package com.blogify.blog_service.dto;

import java.time.Instant;

public class UserBlogCommunication {
    private Long id;
    private String email;
    private String name;
    private Instant createdAt;

    public UserBlogCommunication() {
    }

    public UserBlogCommunication(Long id, String email, String name, Instant createdAt) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }


}
