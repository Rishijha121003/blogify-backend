package com.blogify.user_service.service;

import com.blogify.user_service.dto.*;

public interface UserService {
    UserResponse createUser(UserCreateRequest request);

    LoginResponse login(LoginRequest request);

    UserBlogCommunication getUserById(Long id);

    UserProfile getMyProfile(Long id);
}
