package com.blogify.blog_service.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Comment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String description;
    private Long userId;
    private Long likesCnt;
    private Long dislikesCnt;
    private Instant createdAt;
    private Long createdBy;
    private Instant updatedAt;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "blog_id", nullable = false)
    private Blog blog;

    @JsonManagedReference
    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reply> replyList = new ArrayList<>();

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

    public Blog getBlog() {
        return blog;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", userId=" + userId +
                ", likesCnt=" + likesCnt +
                ", dislikesCnt=" + dislikesCnt +
                ", createdAt=" + createdAt +
                ", createdBy=" + createdBy +
                ", updatedAt=" + updatedAt +

                ", replyList=" + replyList +
                '}';
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
