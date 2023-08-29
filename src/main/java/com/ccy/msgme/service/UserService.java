package com.ccy.msgme.service;

import org.springframework.http.ResponseEntity;

import com.ccy.msgme.request.UserRequest;
import com.ccy.msgme.response.BaseResponse;

public interface UserService {
    public ResponseEntity<BaseResponse<?>> login(UserRequest userRequest);
    
    public ResponseEntity<?> register(UserRequest userRequest);
    
    public ResponseEntity<BaseResponse<?>> checkUser(String username);
}
