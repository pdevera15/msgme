package com.ccy.msgme.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ccy.msgme.document.UserDocument;
import com.ccy.msgme.repository.UserRepository;
import com.ccy.msgme.request.UserRequest;
import com.ccy.msgme.response.BaseResponse;
import com.ccy.msgme.response.ErrorResponse;
import com.ccy.msgme.response.UserResponse;
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
    public ResponseEntity<BaseResponse<?>> login(UserRequest userRequest) {
        Optional<UserDocument> user = userRepository.findByUsername(userRequest.getUsername());
        
        if (user.isPresent() &&
                passwordEncoder.matches(userRequest.getPassword(), user.get().getPassword())) {
            UserResponse response = new UserResponse(user.get().getId(), user.get().getUsername());
            BaseResponse<UserResponse> baseResponse = new BaseResponse<>();
            baseResponse.setData(response);
            baseResponse.setStatus("success");
            baseResponse.setMessage("successfully login");
            return ResponseEntity.status(200).body(baseResponse);
        }
        
        ErrorResponse response = new ErrorResponse();
        response.setErrorCode(ApiError.INVALID_CREDENTIALS.getCode());
        response.setMessage(ApiError.INVALID_CREDENTIALS.getMessage());
        BaseResponse<ErrorResponse> baseResponse = new BaseResponse<>();
        baseResponse.setStatus("failed");
        baseResponse.setMessage("credentials not valid");
        baseResponse.setData(response);
        return ResponseEntity.status(200)
                .body(baseResponse);
        
    }

    @Override
    public ResponseEntity<BaseResponse<?>> register(UserRequest userRequest) {
        // check if username available
        Optional<UserDocument> user = userRepository.findByUsername(userRequest.getUsername());
        if (user.isPresent()) {
            ErrorResponse response = new ErrorResponse();
            response.setErrorCode(ApiError.USERNAME_ALREADY_EXISTS.getCode());
            response.setMessage(ApiError.USERNAME_ALREADY_EXISTS.getMessage());
            
            BaseResponse<ErrorResponse> baseResponse = new BaseResponse<>();
            baseResponse.setStatus("failed");
            baseResponse.setMessage("username already exist");
            baseResponse.setData(response);
            
            return ResponseEntity.status(200).body(baseResponse);
        }

        UserDocument userDocument = new UserDocument();
        userDocument.setUsername(userRequest.getUsername());
        userDocument.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        userDocument.setTimeCreated(System.currentTimeMillis());
        userDocument.setTimeUpdated(System.currentTimeMillis());
        userRepository.save(userDocument);
        
        BaseResponse<ErrorResponse> baseResponse = new BaseResponse<>();
        baseResponse.setStatus("success");
        baseResponse.setMessage("registration success");

        return ResponseEntity.status(200).body(baseResponse);
    }

    @Override
    public ResponseEntity<BaseResponse<?>> checkUser(String username) {
        Optional<UserDocument> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            UserResponse response = new UserResponse();
            response.setId(user.get().getId());
            response.setUsername(user.get().getUsername());
            
            BaseResponse<UserResponse> baseResponse = new BaseResponse<>();
            baseResponse.setStatus("success");
            baseResponse.setMessage("user exist");
            baseResponse.setData(response);
            
            return ResponseEntity.status(200).body(baseResponse);
        }
        
        ErrorResponse response = new ErrorResponse();
        response.setErrorCode(ApiError.INVALID_CREDENTIALS.getCode());
        response.setMessage(ApiError.INVALID_CREDENTIALS.getMessage());
        
        BaseResponse<ErrorResponse> baseResponse = new BaseResponse<>();
        baseResponse.setStatus("failed");
        baseResponse.setMessage("user doesn't exist");
        baseResponse.setData(response);
        return ResponseEntity.status(200)
                .body(baseResponse);
        
    }

}
