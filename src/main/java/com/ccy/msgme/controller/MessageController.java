package com.ccy.msgme.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccy.msgme.document.MessageDocument;
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

    @GetMapping("/{id}")
    public ResponseEntity<?> getMessage(@PathVariable String id) {
        MessageDocument messageDocument = messageService.getMessage(id);
        if (messageDocument != null) {
            return new ResponseEntity<>(messageDocument, HttpStatus.OK);
        }
        return new ResponseEntity<>("No New Message", HttpStatus.OK);
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getMessagesByUser(@PathVariable String userId) {
        List<MessageDocument> messageDocument = messageService.getAllMessageByUserId(userId);
        if (messageDocument != null) {
            return new ResponseEntity<>(messageDocument, HttpStatus.OK);
        }
        return new ResponseEntity<>("No New Message", HttpStatus.OK);
    }
    
    @PostMapping("")
    public ResponseEntity<?> addNewMessage(@RequestBody MessageDocument messageDocument) {
        boolean result = messageService.addMessage(messageDocument);
        if (!result) {
            return new ResponseEntity<>("Successfully Added", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Something went wrong", HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMessage(@PathVariable String id) {
        boolean result = messageService.deleteMessage(id);
        if (result) {
            return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Something went wrong", HttpStatus.OK);
    }
}