package com.travelling.travelling.service.impl;

import com.travelling.travelling.model.Accommodation;
import com.travelling.travelling.model.OrderAcc;
import com.travelling.travelling.model.OrderAccDetail;
import com.travelling.travelling.repository.OrderAccDetailRepository;
import com.travelling.travelling.service.AccommodationService;
import com.travelling.travelling.service.OrderAccDetailService;
import com.travelling.travelling.utils.dto.OrderAccDetailDTO;
import com.travelling.travelling.utils.response.CustomPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderAccDetailServiceImpl implements OrderAccDetailService {
    private final OrderAccDetailRepository orderAccommodationDetailRepository;
    private final AccommodationService accommodationService;

    @Override
    public OrderAccDetail create(OrderAccDetailDTO request) {
        OrderAccDetail newOrder = new OrderAccDetail();
        Accommodation accommodation = accommodationService.getById(request.getAccommodationId());
        OrderAcc orderAccommodation = request.getOrderAccommodation();

        newOrder.setQuantity(request.getQuantity());
        int priceAfterQuantity = request.getQuantity() * accommodation.getPrice();
        newOrder.setPrice(priceAfterQuantity);
        newOrder.setAccommodation(accommodation);
        newOrder.setOrderAccommodation(orderAccommodation);

        return orderAccommodationDetailRepository.save(newOrder);
    }

    @Override
    public CustomPage<OrderAccDetail> getAll(Pageable pageable) {
        var orderAccommodationDetailPage = orderAccommodationDetailRepository.findAll(pageable);
        return new CustomPage<>(orderAccommodationDetailPage);
    }

    @Override
    public OrderAccDetail getOne(Long id) {
        return orderAccommodationDetailRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }
}
