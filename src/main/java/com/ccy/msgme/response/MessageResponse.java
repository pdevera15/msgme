package com.ccy.msgme.response;

public class MessageResponse {
    
    private boolean read;
    
    private String timeCreated;
    
    private String messageContext;
    
    public MessageResponse() {}
    
    public MessageResponse(boolean read, String timeCreated, String messageContext) {
        super();
        this.read = read;
        this.timeCreated = timeCreated;
        this.messageContext = messageContext;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
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
    
}
