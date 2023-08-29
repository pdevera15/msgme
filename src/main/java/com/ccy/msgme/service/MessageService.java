package com.ccy.msgme.service;

import org.springframework.http.ResponseEntity;

import com.ccy.msgme.response.BaseResponse;

public interface MessageService {
    ResponseEntity<BaseResponse<?>> getAllMessageByUserId(String userId);
    
    ResponseEntity<BaseResponse<?>> deleteMessage(String id);
}
