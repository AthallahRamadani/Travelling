package com.travelling.travelling.utils.dto;

import com.travelling.travelling.model.OrderAcc;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderAccDetailDTO {
    private Integer price;
    private Integer quantity;
    private Long accommodationId;
    private OrderAcc orderAccommodation;
}
