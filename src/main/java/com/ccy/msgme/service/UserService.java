package com.ccy.msgme.service;

import org.springframework.http.ResponseEntity;

import com.ccy.msgme.request.UserRequest;

public interface UserService {
    public ResponseEntity<?> login(UserRequest userRequest);
    
    public void register();
    
    public void generateLink();
}
