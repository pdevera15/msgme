package com.ccy.msgme.service;

import java.util.List;

import com.ccy.msgme.document.MessageDocument;

public interface MessageService {
    MessageDocument getMessage(String id);
    
    List<MessageDocument> getAllMessageByUserId(String userId);
    
    boolean addMessage(MessageDocument messageDocument);
    
    boolean deleteMessage(String id);
}
