package com.blogify.user_service.dto;

import java.time.Instant;
import java.util.List;

public class UserResponse {
    private Long id;
    private String email;
    private String name;
    private String mobile;

    private Instant createdAt;
    private Instant updatedAt;
    private List<Long> createdBlogIds;
    private List<Long> commentIds;
    private List<Long> replyIds;

    private List<Long> likedBlogs;
    private List<Long> dislikedBlogs;
    private String profilePhotoUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Long> getCreatedBlogIds() {
        return createdBlogIds;
    }

    public void setCreatedBlogIds(List<Long> createdBlogIds) {
        this.createdBlogIds = createdBlogIds;
    }

    public List<Long> getCommentIds() {
        return commentIds;
    }

    public void setCommentIds(List<Long> commentIds) {
        this.commentIds = commentIds;
    }

    public List<Long> getReplyIds() {
        return replyIds;
    }

    public void setReplyIds(List<Long> replyIds) {
        this.replyIds = replyIds;
    }

    public List<Long> getLikedBlogs() {
        return likedBlogs;
    }

    public void setLikedBlogs(List<Long> likedBlogs) {
        this.likedBlogs = likedBlogs;
    }

    public List<Long> getDislikedBlogs() {
        return dislikedBlogs;
    }

    public void setDislikedBlogs(List<Long> dislikedBlogs) {
        this.dislikedBlogs = dislikedBlogs;
    }

    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    public void setProfilePhotoUrl(String profilePhotoUrl) {
        this.profilePhotoUrl = profilePhotoUrl;
    }
}
