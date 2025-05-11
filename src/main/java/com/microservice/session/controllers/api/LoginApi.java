package com.microservice.session.controllers.api;

import com.microservice.session.dto.input.LoginRequestDto;
import com.microservice.session.dto.output.LoginResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public interface LoginApi {

    @PostMapping("")
    ResponseEntity<LoginResponseDto> login(@RequestBody(required = true)LoginRequestDto loginRequestDto);


}
