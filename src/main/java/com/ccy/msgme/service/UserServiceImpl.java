package com.ccy.msgme.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ccy.msgme.document.UserDocument;
import com.ccy.msgme.repository.UserRepository;
import com.ccy.msgme.request.UserRequest;
import com.ccy.msgme.response.ErrorResponse;
import com.ccy.msgme.util.ApiError;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    
    private final PasswordEncoder passwordEncoder;
    
    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
    @Override
    public ResponseEntity<?> login(UserRequest userRequest) {
        Optional<UserDocument> user = userRepository.findByUsername(userRequest.getUsername());
        if (user.isPresent() &&
                passwordEncoder.matches(userRequest.getPassword(), user.get().getPassword())) {
            return ResponseEntity.status(200).build();
        }
        
        return ResponseEntity.status(401)
                .body(new ErrorResponse(ApiError.INVALID_CREDENTIALS.getCode(),
                ApiError.INVALID_CREDENTIALS.getMessage()));
    }

    @Override
    public ResponseEntity<?> register(UserRequest userRequest) {
        // check if username available
        Optional<UserDocument> user = userRepository.findByUsername(userRequest.getUsername());
        if (user.isPresent()) {
            return ResponseEntity.status(409)
                    .body(new ErrorResponse(ApiError.USERNAME_ALREADY_EXISTS.getCode(), 
                            ApiError.USERNAME_ALREADY_EXISTS.getMessage()));
        }

        UserDocument userDocument = new UserDocument();
        userDocument.setUsername(userRequest.getUsername());
        userDocument.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        userDocument.setTimeCreated(System.currentTimeMillis());
        userDocument.setTimeUpdated(System.currentTimeMillis());
        
        userRepository.save(userDocument);
        
        return ResponseEntity.status(200).build();
    }

    @Override
    public void generateLink() {
        // TODO Auto-generated method stub
        
    }

}
