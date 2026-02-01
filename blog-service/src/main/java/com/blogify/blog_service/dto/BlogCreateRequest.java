package com.blogify.blog_service.dto;

import org.springframework.stereotype.Component;

@Component
public class BlogCreateRequest {

    private String title;
    private String data;
    private Long createdBy;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }


}
