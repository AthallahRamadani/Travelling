package com.travelling.travelling.service.impl;

import com.travelling.travelling.model.Role;
import com.travelling.travelling.model.UserEntity;
import com.travelling.travelling.repository.UserRepository;
import com.travelling.travelling.service.UserService;
import com.travelling.travelling.utils.dto.UserDTO;
import com.travelling.travelling.utils.dto.UserUpdateDTO;
import com.travelling.travelling.utils.response.CustomPage;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserEntity create(UserDTO request) {
        if (userRepository.existsByEmail(request.getEmail()) || userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Email or Username already exists");
        }
        userRepository.saveUser(
                request.getUsername(),
                request.getEmail(),
                request.getPassword(),
                Role.USER.name()
        );

        UserEntity savedUser = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Failed to retrieve the user after insertion"));
        System.out.print(savedUser.getId());
        return savedUser;
    }

    @Override
    public CustomPage<UserEntity> getAll(Pageable pageable, String name) {
        Page<UserEntity> userPage = userRepository.findAllUser(pageable);

        // stream untuk sort nama username ascending/default
        List<UserEntity> sortedUsers = userPage.getContent().stream()
                .sorted(Comparator.comparing(UserEntity::getUsername))
                .collect(Collectors.toList());

        Page<UserEntity> sortedPage = new PageImpl<>(sortedUsers, pageable, userPage.getTotalElements());

        return new CustomPage<>(sortedPage);
    }

    @Override
    public UserEntity getById(Long id) {
        return userRepository.findByIdUser(id)
                .orElseThrow(() -> new RuntimeException("USER WITH ID " + id + " NOT FOUND"));
    }

    @Override
    public UserEntity update(UserUpdateDTO request, Long id) {
        UserEntity updatedUser = this.getById(id);
        updatedUser.setUsername(request.getUsername());
        updatedUser.setEmail(request.getEmail());
        updatedUser.setPassword(request.getPassword());

        userRepository.updateUser(id,
                updatedUser.getUsername(),
                updatedUser.getEmail(),
                updatedUser.getPassword()
        );
        return updatedUser;
    }


    @Override
    public String deleteById(Long id) {
        userRepository.deleteByIdUser(id);
        return "User with id " + id + " deleted";
    }
}
