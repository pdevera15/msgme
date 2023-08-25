package com.ccy.msgme.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    
    private final UserService userService;
    
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequest userRequest) {
        ResponseEntity<?> response = userService.login(userRequest);
        return response;
    }
    
    @PostMapping("/register")
    public void register(@RequestBody UserRequest userRequest) {
        
    }
    
    @GetMapping("/generatelink")
    public void generateLink() {
        
    }
}
