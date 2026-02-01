package com.blogify.blog_service.repository;

import com.blogify.blog_service.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
