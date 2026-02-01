package com.blogify.blog_service.dto;

public class BlogLikeDislikeResponse {
    private String message;
    private String likedOrDisliked;
    private Long likesCnt;
    private Long dislikeCnt;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLikedOrDisliked() {
        return likedOrDisliked;
    }

    public void setLikedOrDisliked(String likedOrDisliked) {
        this.likedOrDisliked = likedOrDisliked;
    }

    public Long getLikesCnt() {
        return likesCnt;
    }

    public void setLikesCnt(Long likesCnt) {
        this.likesCnt = likesCnt;
    }

    public Long getDislikeCnt() {
        return dislikeCnt;
    }

    public void setDislikeCnt(Long dislikeCnt) {
        this.dislikeCnt = dislikeCnt;
    }
}
