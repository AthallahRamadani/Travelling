package com.travelling.travelling.utils.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserChangeProfilePictureDTO {
    @NotNull
    private MultipartFile profile_picture;
}
