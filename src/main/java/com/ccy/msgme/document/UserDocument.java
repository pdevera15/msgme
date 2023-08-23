package com.ccy.msgme.document;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document("user")
public class UserDocument {
    
    @MongoId
    private String id;
    
    private String username;
    
    private String password;
    
    private String timeCreated;
    
    private String timeUpdated;
    
    private String nickname;
    
}
