package com.blogify.blog_service.dto;



import java.time.Instant;
import java.util.List;

public class Comment {

    private Long id;
    private String description;
    private Long userId;
    private Long likesCnt;
    private Long dislikesCnt;
    private Instant createdAt;
    private Long createdBy;
    private Instant updatedAt;
    private List<Reply> replyList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getLikesCnt() {
        return likesCnt;
    }

    public void setLikesCnt(Long likesCnt) {
        this.likesCnt = likesCnt;
    }

    public Long getDislikesCnt() {
        return dislikesCnt;
    }

    public void setDislikesCnt(Long dislikesCnt) {
        this.dislikesCnt = dislikesCnt;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Reply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<Reply> replyList) {
        this.replyList = replyList;
    }
}
