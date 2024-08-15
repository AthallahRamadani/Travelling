package com.travelling.travelling.service.impl;

import com.travelling.travelling.model.*;
import com.travelling.travelling.repository.OrderAccRepository;
import com.travelling.travelling.service.AccommodationService;
import com.travelling.travelling.service.OrderAccDetailService;
import com.travelling.travelling.service.OrderAccService;
import com.travelling.travelling.service.UserService;
import com.travelling.travelling.utils.dto.OrderAccDTO;
import com.travelling.travelling.utils.dto.OrderAccDetailDTO;
import com.travelling.travelling.utils.response.CustomPage;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderAccServiceImpl implements OrderAccService {
    private final OrderAccRepository orderAccommodationRepository;
    private final OrderAccDetailService orderAccommodationDetailService;
    private final UserService userService;
    private final AccommodationService accommodationService;

    @Override
    @Transactional
    public OrderAcc create(OrderAccDTO request) {
        UserEntity user = userService.getById(request.getUserId());
        List<OrderAccDetailDTO> details = request.getOrderAccDetails();
        OrderAcc newOrderAccommodation = new OrderAcc();
        newOrderAccommodation.setUser(user);
        newOrderAccommodation.setCheckIn(request.getCheckIn());
        newOrderAccommodation.setCheckOut(request.getCheckOut());

        OrderAcc result = orderAccommodationRepository.save(newOrderAccommodation);
        int pricePlaceHolder = 0;
        List<OrderAccDetail> oad_list = new ArrayList<>();
        for (OrderAccDetailDTO detail : details) {
            Accommodation acc = accommodationService.getById(detail.getAccommodationId());
            Integer cat_price = acc.getPrice();

            int qty = detail.getQuantity();
            cat_price *= qty;

            detail.setOrderAccommodation(result);
            pricePlaceHolder += cat_price;
            OrderAccDetail oad = orderAccommodationDetailService.create(detail);
            oad_list.add(oad);
        }
        if (request.getCheckIn().isAfter(request.getCheckOut())) {
            throw new IllegalArgumentException("Check-in date must be before the checkout date.");
        }

        LocalDate checkIn = request.getCheckIn();
        LocalDate checkout = request.getCheckOut();

        long dayStay = ChronoUnit.DAYS.between(checkIn, checkout);
        int totalday = (int) dayStay;
        pricePlaceHolder = totalday * pricePlaceHolder;

        result.setTotalPrice(pricePlaceHolder);
        result.setAccommodationDetails(oad_list);
        result.setStatus(PaymentStatus.PROCESSING);
        return orderAccommodationRepository.save(result);
    }

    @Override
    public CustomPage<OrderAcc> getAll(Pageable pageable, Long userId, Integer totalPrice, LocalDate checkIn, LocalDate checkOut) {
        return null;
    }

    @Override
    public OrderAcc getOne(String id) {
        return null;
    }

    @Override
    public void updatePaymentStatus(String id, PaymentStatus status) {

    }
}
