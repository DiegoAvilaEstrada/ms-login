package com.microservice.session.rest.client;

import com.microservice.session.dto.client.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "user-api", url = "${rest.client.user-url}")
public interface UserApiClient {


    @GetMapping("/user")
    UserResponse getUserByUsername(@RequestHeader(value = "x-authorization") String xAuthorization, @RequestHeader String user, @RequestHeader String password);
}
