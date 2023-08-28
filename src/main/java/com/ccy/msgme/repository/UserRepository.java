package com.ccy.msgme.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ccy.msgme.document.UserDocument;

public interface UserRepository  extends MongoRepository<UserDocument, String> {
    public Optional<UserDocument> findByUsername(String username);
}
