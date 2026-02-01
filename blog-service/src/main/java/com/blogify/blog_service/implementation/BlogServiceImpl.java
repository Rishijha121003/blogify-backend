package com.blogify.blog_service.implementation;

import com.blogify.blog_service.Mapper.BlogMapper;
import com.blogify.blog_service.dto.*;
import com.blogify.blog_service.entity.Blog;
import com.blogify.blog_service.exception.UserNotFoundException;
import com.blogify.blog_service.repository.BlogRepo;
import com.blogify.blog_service.repository.CommentRepo;
import com.blogify.blog_service.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.blogify.blog_service.entity.Comment;

import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepo blogRepo;
    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private BlogMapper blogMapper;
    @Value("${user.micro.url}")
    private String userURL;
    @Override
    public Optional<List<Blog>> getAllBlogs() {
        return Optional.of(blogRepo.findAll());
    }

    @Override
    public BlogResponse addNewBlog(BlogCreateRequest request) {

        UserBlogCommunication req = new UserBlogCommunication(request.getCreatedBy(), null,null,null);
        Long id = request.getCreatedBy();
        RestTemplate restTemplate = new RestTemplate();
        String url = userURL+"/getUserById";
        UserBlogCommunication communication = null;

        try {
            ResponseEntity<UserBlogCommunication> response = restTemplate.postForEntity(
                    url,
                    req,
                    UserBlogCommunication.class
            );

            communication = response.getBody();
        } catch (Exception e) {
            throw new UserNotFoundException("User with userId "+id +" not found!!");
        }
        if (communication == null)  {
            throw new UserNotFoundException("User with userId "+id +" not found!!");
        }
        Blog blog = blogMapper.toBlog(request);
        Blog savedBlog =  blogRepo.save(blog);

        return blogMapper.toBlogResponse(savedBlog);
    }

    @Override
    public BlogLikeDislikeResponse liked(BlogLikedRequest request) {
        BlogLikeDislikeResponse response = new BlogLikeDislikeResponse();
        Long blogId = request.getBlogId();
        Optional<Blog> blog = blogRepo.findById(blogId);
        Blog dbBlog = null;
        Blog saved = null;
        if (blog.isPresent()) {
            dbBlog = blog.get();
            String likedOrDisliked = response.getLikedOrDisliked();

            dbBlog.setLikesCount(dbBlog.getLikesCount() + 1);
            saved = blogRepo.save(dbBlog);
            response.setLikedOrDisliked("LIKED");
            response.setLikesCnt(saved.getLikesCount());
            response.setDislikeCnt(saved.getDislikesCount());
            return response;
        }
        return null;
    }



    @Override
    public BlogLikeDislikeResponse disliked(BlogDislikedRequest request) {
        BlogLikeDislikeResponse response = new BlogLikeDislikeResponse();
        Long blogId = request.getBlogId();
        Optional<Blog> blog = blogRepo.findById(blogId);
        Blog dbBlog = null;
        Blog saved = null;
        if (blog.isPresent()) {
            dbBlog = blog.get();
            dbBlog.setDislikesCount(dbBlog.getDislikesCount() + 1);
            saved = blogRepo.save(dbBlog);
            response.setLikedOrDisliked("DISLIKED");
            response.setLikesCnt(saved.getLikesCount());
            response.setDislikeCnt(saved.getDislikesCount());
            return response;
        }
        return null;
    }

    @Override
    public CreateCommentResponse createComment(CreateCommentRequest request) {
        CreateCommentResponse response = new CreateCommentResponse();
        Long blogId = request.getBlogId();
        List<Comment> comments = null;
        Optional<Blog> optionalBlog = blogRepo.findById(blogId);

        if (optionalBlog.isEmpty()){
            return null;
        }

        Blog blog = optionalBlog.get();
        Comment comment = blogMapper.toNewComment(request,blog);
        Comment savedComment = commentRepo.save(comment);
        comments = blog.getComments();
        if(null == comments) {
            comments = new ArrayList<>();

        }
        comments.add(savedComment);

       Blog savedBlog =  blogRepo.save(blog);
       response.setBlogId(savedBlog.getId());
       response.setComment(request.getComment());
       response.setCreatedAt(savedBlog.getCreatedAt());
       response.setUserId(comment.getUserId());
       return response;
    }

    @Override
    public BlogResponse getByBlogId(Long id) {
        Optional<Blog> optionalBlog = blogRepo.findById(id);
        if (optionalBlog.isEmpty()) return null;
        Blog blog = optionalBlog.get();
        System.out.println(blog);
        return blogMapper.toBlogResponse(blog);

    }
}
