package com.blogify.blog_service.Mapper;

import com.blogify.blog_service.dto.BlogCreateRequest;
import com.blogify.blog_service.dto.BlogResponse;
import com.blogify.blog_service.dto.CreateCommentRequest;
import com.blogify.blog_service.entity.Blog;
import com.blogify.blog_service.entity.Comment;
import com.blogify.blog_service.entity.Reply;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Component
public class BlogMapper {
    public BlogResponse toBlogResponse (Blog savedBlog){
        BlogResponse response = new BlogResponse();
        response.setId(savedBlog.getId());
        response.setTitle(savedBlog.getTitle());
        response.setData(savedBlog.getData());
        response.setCreatedAt(savedBlog.getCreatedAt());
        response.setCreatedBy(savedBlog.getCreatedBy());
        response.setLikesCount(savedBlog.getLikesCount());
        response.setDislikesCount(savedBlog.getDislikesCount());
        List<Comment> entComms = savedBlog.getComments();
        List<com.blogify.blog_service.dto.Comment> DTOComms = new ArrayList<>();
        if (entComms!= null) {
            for (Comment comment : entComms) {
                DTOComms.add(toCommentDTO(comment));

            }
        }
        response.setCommentList(DTOComms);


        return response;
    }
    public com.blogify.blog_service.dto.Comment toCommentDTO (Comment req) {
        com.blogify.blog_service.dto.Comment comment = new com.blogify.blog_service.dto.Comment();
        comment.setUpdatedAt(req.getUpdatedAt());
        comment.setLikesCnt(req.getLikesCnt());
        comment.setDislikesCnt(req.getDislikesCnt());
        comment.setCreatedAt(req.getCreatedAt());
        comment.setCreatedBy(req.getCreatedBy());
        comment.setDescription(req.getDescription());
        comment.setId(req.getId());
        comment.setUserId(req.getUserId());
        List<Reply> entRep = req.getReplyList();
        List<com.blogify.blog_service.dto.Reply> ans = new ArrayList<>();
        if(null != entRep) {
            for (Reply reply : entRep) {
                ans.add(toReplyDTO(reply));
            }
        }
        comment.setReplyList(ans);
        return comment;
    }
    public com.blogify.blog_service.dto.Reply toReplyDTO (Reply req) {
        com.blogify.blog_service.dto.Reply comment = new com.blogify.blog_service.dto.Reply();
        comment.setUpdatedAt(req.getUpdatedAt());

        comment.setCreatedAt(req.getCreatedAt());
        comment.setDescription(req.getDescription());
        comment.setId(req.getId());
        comment.setUserId(req.getUserId());
        comment.setCreatedBy(req.getCreatedBy());
        return comment;
    }

    public Blog toBlog( BlogCreateRequest request){
        Blog blog = new Blog();

        blog.setTitle(request.getTitle());
        blog.setData(request.getData());
        blog.setCreatedBy(request.getCreatedBy());
        blog.setCreatedAt(Instant.now());
        blog.setUpdatedAt(Instant.now());
        blog.setLikesCount(0L);
        blog.setDislikesCount(0L);
        blog.setComments(null);
        return blog;
    }
    public Comment toNewComment (CreateCommentRequest request, Blog blog) {
        Comment comment = new Comment();
        comment.setDescription(request.getComment());
        comment.setCreatedAt(Instant.now());
        comment.setCreatedBy(request.getUserId());
        comment.setDislikesCnt(0L);
        comment.setLikesCnt(0L);
        comment.setReplyList(null);
        comment.setUpdatedAt(null);
        comment.setBlog(blog);
        comment.setUserId(request.getUserId());
        return comment;
    }
}
