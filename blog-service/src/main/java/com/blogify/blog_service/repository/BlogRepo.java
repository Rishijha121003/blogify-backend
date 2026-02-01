package com.blogify.blog_service.repository;

import com.blogify.blog_service.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepo extends JpaRepository<Blog, Long> {
    public Optional<Blog> findByCreatedAt (Instant createdAt);
    public Optional<List<Blog>> findByCreatedBy (Long createdBy);
}
