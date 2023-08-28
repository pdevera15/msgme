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
import com.ccy.msgme.response.LoginResponse;
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
            LoginResponse response = new LoginResponse(user.get().getId(), user.get().getUsername());
            BaseResponse<LoginResponse> baseResponse = new BaseResponse<>();
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
        baseResponse.setMessage("Credentials Failed");
        baseResponse.setData(response);
        return ResponseEntity.status(401)
                .body(baseResponse);
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
