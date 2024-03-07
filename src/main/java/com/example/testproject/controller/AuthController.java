package com.example.testproject.controller;

import com.example.testproject.entity.BlogUser;
import com.example.testproject.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<BlogUser> authenticate(@RequestBody BlogUser user){
        return ResponseEntity.ok(authService.authenticate(user));
    }
}


// authority : 회원가입, 인가
// authentication : 로그인, 인증