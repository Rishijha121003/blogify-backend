package com.blogify.user_service.controller;

import com.blogify.user_service.dto.*;
import com.blogify.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@CrossOrigin("*")
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserCreateRequest request){
        UserResponse response = userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(Objects.requireNonNullElse(response, "User already exists with this email id."));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login (@RequestBody LoginRequest request){
        LoginResponse response = userService.login(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
    @PostMapping("/getUserById")
    public ResponseEntity<UserBlogCommunication> getUserById(@RequestBody UserBlogCommunication req) {
        UserBlogCommunication communication = userService.getUserById(req.getId());
        if (communication==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(communication);
    }
    @GetMapping("/getMyProfile")
    public ResponseEntity<UserProfile> getMyProfile(@RequestBody UserBlogCommunication req){
       UserProfile  userProfie  = userService.getMyProfile(req.getId());
        if (userProfile==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(userProfile);
    }
}
