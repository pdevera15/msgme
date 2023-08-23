package com.ccy.msgme.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("message")
public class MessageDocument {
    
    @Id
    private String id;
    
    private String timeCreated;
    
    private String messageContext;
    
    private String createdToUserId;
    
    private boolean read;

    public MessageDocument() {};
    
    public MessageDocument(String id, String timeCreated, String messageContext, String createdToUserId, boolean read) {
        super();
        this.id = id;
        this.timeCreated = timeCreated;
        this.messageContext = messageContext;
        this.createdToUserId = createdToUserId;
        this.read = read;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }

    public String getMessageContext() {
        return messageContext;
    }

    public void setMessageContext(String messageContext) {
        this.messageContext = messageContext;
    }

    public String getCreatedToUserId() {
        return createdToUserId;
    }

    public void setCreatedToUserId(String createdToUserId) {
        this.createdToUserId = createdToUserId;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }
    
}
