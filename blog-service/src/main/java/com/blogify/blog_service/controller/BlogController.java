package com.blogify.blog_service.controller;

import com.blogify.blog_service.dto.*;
import com.blogify.blog_service.entity.Blog;
import com.blogify.blog_service.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RequestMapping("/blog")
@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping
    public ResponseEntity<Optional<List<Blog>>> getAllBlogs () {
        Optional<List<Blog>> listOfBlogs =  blogService.getAllBlogs();
        return ResponseEntity.status(HttpStatus.OK).body(listOfBlogs);
    }

    @PostMapping
    public ResponseEntity<BlogResponse> addNewBlog (@RequestBody BlogCreateRequest request) {
        BlogResponse response = blogService.addNewBlog (request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/liked")
    public ResponseEntity<BlogLikeDislikeResponse> likedOrDisliked (@RequestBody BlogLikedRequest request){
        BlogLikeDislikeResponse response = blogService.liked(request);
        if(null != response)
            response.setMessage("Message Liked Successfully.");
        else {
            response = new BlogLikeDislikeResponse();
            response.setMessage("Blog id is not available");
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PostMapping("/disliked")
    public ResponseEntity<BlogLikeDislikeResponse> likedOrDisliked (@RequestBody BlogDislikedRequest request){
        BlogLikeDislikeResponse response = blogService.disliked(request);
        if(null != response)
            response.setMessage("Message Disliked Successfully.");
      else {
            response = new BlogLikeDislikeResponse();
            response.setMessage("Blog id is not available");
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PostMapping("/comment")
    public ResponseEntity<CreateCommentResponse>  createComment (@RequestBody CreateCommentRequest request){
        CreateCommentResponse response = blogService.createComment(request);
        if(null != response)
            response.setMessage("Commented Successfully.");
        else {
            response = new CreateCommentResponse();
            response.setMessage("Blog/User id is not available");
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/getByBlogId/{id}")
    public ResponseEntity<BlogResponse> getByBlogId (@PathVariable Long id) {
        BlogResponse response = blogService.getByBlogId(id);
        if (response==null){
            response = new BlogResponse();
            response.setData("Blog not found with this id.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }


}
