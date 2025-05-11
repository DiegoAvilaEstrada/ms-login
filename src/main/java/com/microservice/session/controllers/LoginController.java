package com.microservice.session.controllers;


import com.microservice.session.controllers.api.LoginApi;
import com.microservice.session.dto.input.LoginRequestDto;
import com.microservice.session.dto.client.UserResponse;
import com.microservice.session.dto.output.LoginResponseDto;
import com.microservice.session.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class LoginController implements LoginApi {

    private final SessionService sessionService;

    @Override
    public ResponseEntity<LoginResponseDto> login(LoginRequestDto loginRequestDto) {
        return new ResponseEntity<>(sessionService.getUserByUserName(loginRequestDto.getUsername(), loginRequestDto.getPassword()), HttpStatus.ACCEPTED);
    }
}
