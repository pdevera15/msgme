package com.ccy.msgme.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ccy.msgme.document.UserDocument;
import com.ccy.msgme.repository.UserRepository;
import com.ccy.msgme.request.UserRequest;
import com.ccy.msgme.response.ErrorResponse;
import com.ccy.msgme.util.ApiError;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public ResponseEntity<?> login(UserRequest userRequest) {
        // find username if available
        UserDocument userDocument = new UserDocument();
        userDocument.setUsername(userRequest.getUsername());
        
        if (userRepository.existsByUsername(userDocument.getUsername())) {
            return ResponseEntity.status(409)
                    .body(new ErrorResponse(String.valueOf(ApiError.USERNAME_ALREADY_EXISTS.getCode()), 
                            ApiError.USERNAME_ALREADY_EXISTS.getMessage()));
        }
        return ResponseEntity.status(200).build();
        // generate hash password
        
        // 
        
    }

    @Override
    public void register() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void generateLink() {
        // TODO Auto-generated method stub
        
    }

}
