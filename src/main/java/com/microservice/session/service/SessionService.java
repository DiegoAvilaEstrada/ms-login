package com.microservice.session.service;


import com.microservice.session.dto.client.UserResponse;
import com.microservice.session.dto.output.LoginResponseDto;
import com.microservice.session.rest.client.UserApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionService {

    private final UserApiClient userApiClient;

    public LoginResponseDto getUserByUserName(String username, String password){
        UserResponse userResponse = userApiClient.getUserByUsername("jeje xD",username,password);
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        loginResponseDto.setId(userResponse.getUserId());
        loginResponseDto.setEmail(userResponse.getEmail());

        return loginResponseDto;
    }
}
