package com.blogify.blog_service.service;

import com.blogify.blog_service.dto.*;
import com.blogify.blog_service.entity.Blog;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface BlogService {


    public Optional<List<Blog>> getAllBlogs();

    BlogResponse addNewBlog(BlogCreateRequest request);

    BlogLikeDislikeResponse liked(BlogLikedRequest request);

    BlogLikeDislikeResponse disliked(BlogDislikedRequest request);

    CreateCommentResponse createComment(CreateCommentRequest request);

    BlogResponse getByBlogId(Long id);
}
