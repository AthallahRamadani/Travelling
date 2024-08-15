package com.travelling.travelling.controller;

import com.travelling.travelling.service.AuthService;
import com.travelling.travelling.utils.dto.AuthDTO;
import com.travelling.travelling.utils.dto.RegisterDTO;
import com.travelling.travelling.utils.response.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody AuthDTO req) {
        return Response.renderJSON(
                authService.login(req)
        );
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterDTO req) {
        return Response.renderJSON(
                authService.register(req),
                "Success",
                HttpStatus.CREATED
        );
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(
            @RequestHeader("Authorization") String refreshToken) {
        return Response.renderJSON(
                authService.refreshToken(refreshToken)
        );
    }
}