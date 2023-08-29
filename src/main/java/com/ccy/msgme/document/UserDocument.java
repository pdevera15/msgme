package com.ccy.msgme.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
public class UserDocument {
    
    @Id
    private String id;

    private String username;
    
    private String password;
    
    private long timeCreated;
    
    private long timeUpdated;
    
    private String nickname;

    public UserDocument() {
    }
    
    public UserDocument(String id, String username, String password, long timeCreated, long timeUpdated,
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

    public long getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(long timeCreated) {
        this.timeCreated = timeCreated;
    }

    public long getTimeUpdated() {
        return timeUpdated;
    }

    public void setTimeUpdated(long timeUpdated) {
        this.timeUpdated = timeUpdated;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
}
