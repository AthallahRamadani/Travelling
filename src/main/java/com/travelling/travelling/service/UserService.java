package com.travelling.travelling.service;

import com.travelling.travelling.model.UserEntity;
import com.travelling.travelling.utils.dto.UserChangeProfilePictureDTO;
import com.travelling.travelling.utils.dto.UserDTO;
import com.travelling.travelling.utils.dto.UserUpdateDTO;
import com.travelling.travelling.utils.response.CustomPage;
import org.springframework.data.domain.Pageable;

public interface UserService {
    UserEntity create(UserDTO request);
    CustomPage<UserEntity> getAll(Pageable pageable, String name);
    UserEntity getById(Long id);
    UserEntity update(UserUpdateDTO request, Long id);
    String changeProfilePicture(UserChangeProfilePictureDTO request, Long id);
    String deleteById(Long id);
}
