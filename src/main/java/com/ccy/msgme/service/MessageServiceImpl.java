package com.ccy.msgme.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.ccy.msgme.document.MessageDocument;
import com.ccy.msgme.repository.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService {
    
    private final MessageRepository messageRepository;
    
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
    
    public MessageDocument getMessage(String id) throws NoSuchElementException {
        Optional<MessageDocument> messageDocument = messageRepository.findById(id);
        if(messageDocument.isPresent()) {
            return messageDocument.get();
        }
        return null;
    }

    public List<MessageDocument> getAllMessageByUserId(String userId) {
        List<MessageDocument> messageDocumentList = messageRepository.findAllMessageByUserId(new ObjectId(userId));
        return messageDocumentList;
    }

    public boolean addMessage(MessageDocument messageDocument) {
        messageRepository.save(messageDocument);
        return true;
    }
    
    public boolean deleteMessage(String id) {
        messageRepository.deleteById(id);
        return true;
    }
    
}
