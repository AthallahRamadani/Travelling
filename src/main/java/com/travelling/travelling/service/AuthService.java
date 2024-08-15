package com.travelling.travelling.service;

import com.travelling.travelling.utils.dto.AuthDTO;
import com.travelling.travelling.utils.dto.RegisterDTO;
import com.travelling.travelling.utils.response.AuthResponse;

public interface AuthService {
    AuthResponse login(AuthDTO req);
    AuthResponse register(RegisterDTO req);
    AuthResponse refreshToken(String refreshToken);
}
