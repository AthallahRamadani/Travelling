package com.travelling.travelling.utils.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderAccDTO {
    private Long userId;
    private List<OrderAccDetailDTO> orderAccDetails;
    private LocalDate checkIn;
    private LocalDate checkOut;
}
