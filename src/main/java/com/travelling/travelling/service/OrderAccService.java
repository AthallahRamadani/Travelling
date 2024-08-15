package com.travelling.travelling.service;

import com.travelling.travelling.model.OrderAcc;
import com.travelling.travelling.model.PaymentStatus;
import com.travelling.travelling.utils.dto.OrderAccDTO;
import com.travelling.travelling.utils.response.CustomPage;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface OrderAccService {
    OrderAcc create(OrderAccDTO request);

    CustomPage<OrderAcc> getAll(Pageable pageable, Long userId, Integer totalPrice, LocalDate checkIn, LocalDate checkOut);

    OrderAcc getOne(String id);

    void updatePaymentStatus(String id, PaymentStatus status);

}
