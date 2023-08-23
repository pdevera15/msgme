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

    public UserDocument() {
    }
    
    public UserDocument(String id, String username, String password, String timeCreated, String timeUpdated,
            String nickname) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.timeCreated = timeCreated;
        this.timeUpdated = timeUpdated;
        this.nickname = nickname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }

    public String getTimeUpdated() {
        return timeUpdated;
    }

    public void setTimeUpdated(String timeUpdated) {
        this.timeUpdated = timeUpdated;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
}
