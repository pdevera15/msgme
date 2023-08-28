package com.ccy.msgme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccy.msgme.request.UserRequest;
import com.ccy.msgme.service.UserService;

@RestController
@RequestMapping("v1/user")
public class UserController {
    
    private final UserService userService;
    
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequest userRequest) {
        return userService.login(userRequest);
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRequest userRequest) {
        return userService.register(userRequest);
    }
    
    @GetMapping("/generatelink")
    public void generateLink() {
        
    }
}
