package com.ccy.msgme.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ccy.msgme.document.UserDocument;

public interface UserRepository  extends MongoRepository<UserDocument, String> {
    public boolean existsByUsername(String username);
}
