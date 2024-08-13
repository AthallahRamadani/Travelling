package com.travelling.travelling.service.impl;

import com.travelling.travelling.model.UserEntity;
import com.travelling.travelling.repository.UserRepository;
import com.travelling.travelling.service.CloudinaryService;
import com.travelling.travelling.service.UserService;
import com.travelling.travelling.utils.dto.UserChangeProfilePictureDTO;
import com.travelling.travelling.utils.dto.UserDTO;
import com.travelling.travelling.utils.dto.UserUpdateDTO;
import com.travelling.travelling.utils.response.CustomPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CloudinaryService cloudinaryService;

    @Override
    public UserEntity create(UserDTO request) {
        UserEntity user = new UserEntity();
        user.setUsername(request.getUserName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setProfile_picture(cloudinaryService.uploadFile(request.getProfile_picture(), "travelwise_user"));

        userRepository.saveUser(
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getRole().name(),
                user.getProfile_picture()
        );
        return user;
    }

    @Override
    public CustomPage<UserEntity> getAll(Pageable pageable, String name) {
        return null;
    }

    @Override
    public UserEntity getById(Long id) {
        return null;
    }

    @Override
    public UserEntity update(UserUpdateDTO request, Long id) {
        return null;
    }

    @Override
    public String changeProfilePicture(UserChangeProfilePictureDTO request, Long id) {
        return "";
    }

    @Override
    public String deleteById(Long id) {
        return "";
    }
}
