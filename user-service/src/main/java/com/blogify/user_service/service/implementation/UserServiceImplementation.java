package com.blogify.user_service.service.implementation;

import com.blogify.user_service.dto.*;
import com.blogify.user_service.entity.User;
import com.blogify.user_service.exception.AccountNotFoundException;
import com.blogify.user_service.exception.WrongPasswordException;
import com.blogify.user_service.mapper.UserMapper;
import com.blogify.user_service.repository.UserRepo;
import com.blogify.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserMapper mapper;

    @Override
    public UserResponse createUser(UserCreateRequest request) {

        Boolean created = userRepo.existsByEmail(request.getEmail());
        if (created) return null;
        User user = mapper.toUser(request);
        // :LOGIC for IMAGE SETTING> AND URL generation
        user.setProfilePhotoUrl("lskdjisudsd/sdjsidjs/sdmsid.sdjsdisdis");
        // END
        User saved = userRepo.save(user);

        return mapper.toUserResponse(saved);

    }

    @Override
    public LoginResponse login(LoginRequest request) {
        LoginResponse response = new LoginResponse();
        Optional<User> optionalUser = userRepo.findByEmail(request.getEmail());
        if (optionalUser.isEmpty()) {
            throw new AccountNotFoundException("Account not found. Please create a new One.");
        }
        User user = optionalUser.get();
        boolean matched = user.getPassword().equals(request.getPassword());
        if (!matched){
            throw new WrongPasswordException("Password is wrong!!");
        }
        response.setMessage("Login Successful.");
        response.setUserId(String.valueOf( user.getId()));
        response.setData(mapper.toUserResponse(user));
        return response;
    }

    @Override
    public UserBlogCommunication getUserById(Long id) {
        Optional<User> optionalUser = userRepo.findById(id);

        if (optionalUser.isEmpty()) {
            return null;
        }

        User user = optionalUser.get();

        return new UserBlogCommunication(
                user.getId(),
                user.getEmail(),
                user.getName(),
                user.getCreatedAt()
        );
    }
}
