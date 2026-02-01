package com.blogify.user_service.mapper;

import com.blogify.user_service.dto.UserCreateRequest;
import com.blogify.user_service.dto.UserResponse;
import com.blogify.user_service.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toUser (UserCreateRequest request){
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setMobile(request.getMobile());
        user.setName(request.getName());
        return user;
    }
    public UserResponse toUserResponse(User user) {
        UserResponse response = new UserResponse();

        response.setCommentIds(user.getCommentIds());
        response.setCreatedAt(user.getCreatedAt());
        response.setCreatedBlogIds(user.getCreatedBlogIds());
        response.setDislikedBlogs(user.getDislikedBlogs());
        response.setEmail(user.getEmail());
        response.setId(user.getId());
        response.setLikedBlogs(user.getLikedBlogs());
        response.setMobile(user.getMobile());
        response.setName(user.getName());
        response.setReplyIds(user.getReplyIds());
        response.setProfilePhotoUrl(user.getProfilePhotoUrl());
        response.setUpdatedAt(user.getUpdatedAt());
        return response;
    }
}
