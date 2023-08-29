package com.ccy.msgme.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccy.msgme.response.BaseResponse;
import com.ccy.msgme.service.MessageService;

@RestController
@RequestMapping("v1/message")
public class MessageController {

    Logger logger = LoggerFactory.getLogger(MessageController.class);
    
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<BaseResponse<?>> getMessagesByUser(@PathVariable String userId) {
        return messageService.getAllMessageByUserId(userId);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<?>> deleteMessage(@PathVariable String id) {
        return messageService.deleteMessage(id);
    }
}