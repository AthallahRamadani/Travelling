package com.travelling.travelling.service;

import com.travelling.travelling.model.OrderAccDetail;
import com.travelling.travelling.utils.dto.OrderAccDetailDTO;
import com.travelling.travelling.utils.response.CustomPage;
import org.springframework.data.domain.Pageable;

public interface OrderAccDetailService {
    OrderAccDetail create(OrderAccDetailDTO request);
    CustomPage<OrderAccDetail> getAll(Pageable pageable);
    OrderAccDetail getOne(Long id);

}
