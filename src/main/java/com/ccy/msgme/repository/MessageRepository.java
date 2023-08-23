package com.ccy.msgme.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ccy.msgme.document.MessageDocument;

public interface MessageRepository extends MongoRepository<MessageDocument, String>{
    
    @Query("{ createdToUserId: ?0 }")
    List<MessageDocument> findAllMessageByUserId(ObjectId id);
    
}
