package com.travelling.travelling.security;

import com.travelling.travelling.model.UserEntity;
import com.travelling.travelling.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserSecurity {
    private final UserRepository userRepository;

    public boolean hasUserId(Authentication authentication, Long userId) {
        UserEntity user = userRepository.findByUsername(authentication.getName()).orElse(null);
        assert user != null;
        Long currentUserId = user.getId();
        return currentUserId.equals(userId);
    }

    public boolean isUser(Authentication authentication, int userId) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return false;
        }
        Object principal = authentication.getPrincipal();
        if (!(principal instanceof User)) {
            return false;
        }
        UserEntity user = (UserEntity) principal;
        return user.getId() == userId;
    }
}
