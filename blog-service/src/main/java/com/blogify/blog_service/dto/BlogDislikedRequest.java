package com.blogify.blog_service.dto;

import org.springframework.stereotype.Component;

@Component
public class BlogDislikedRequest {
    private Long blogId;

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }
}
