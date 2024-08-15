package com.travelling.travelling.utils.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccommodationDTO {
    private String name;

    private String location;

    private String category;

    private Integer price;

}
