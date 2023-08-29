package com.ccy.msgme.service;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ccy.msgme.document.MessageDocument;
import com.ccy.msgme.repository.MessageRepository;
import com.ccy.msgme.response.BaseResponse;
import com.ccy.msgme.response.MessageResponse;

@Service
public class MessageServiceImpl implements MessageService {
    
    private final MessageRepository messageRepository;
    
    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
    
    public ResponseEntity<BaseResponse<?>> getAllMessageByUserId(String userId) {
        List<MessageDocument> messageDocumentList = messageRepository.findAllMessageByUserId(new ObjectId(userId));
        List<MessageResponse> responseList = new ArrayList<>();
        for (MessageDocument message : messageDocumentList) {
            MessageResponse response = new MessageResponse();
            response.setMessageContext(message.getMessageContext());
            response.setTimeCreated(message.getCreatedToUserId());
            response.setRead(message.isRead());
            
            responseList.add(response);
        }
        
        BaseResponse<List<MessageResponse>> baseResponse = new BaseResponse<>();
        baseResponse.setStatus("success");
        baseResponse.setMessage("successfully retrieved the message");
        baseResponse.setData(responseList);
        return ResponseEntity.status(200).body(baseResponse);
    }

    public ResponseEntity<BaseResponse<?>> deleteMessage(String id) {
        messageRepository.deleteById(id);
        BaseResponse<?> baseResponse = new BaseResponse<>();
        baseResponse.setStatus("success");
        baseResponse.setMessage("successfully delete message");
        return ResponseEntity.status(200).body(baseResponse);
    }
    
}
