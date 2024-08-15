package com.travelling.travelling.controller;

import com.travelling.travelling.service.OrderAccService;
import com.travelling.travelling.service.TransactionService;
import com.travelling.travelling.utils.dto.OrderAccDTO;
import com.travelling.travelling.utils.dto.OrderAccommodationDTO;
import com.travelling.travelling.utils.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/order_accommodations")
@RequiredArgsConstructor
public class OrderAccController {
    private final OrderAccService orderAccommodationService;
    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody OrderAccDTO request) {
        return Response.renderJSON(transactionService.createOrderAccommodation(request), "CREATE ORDER ACCOMMODATION");
    }

    @GetMapping
    public ResponseEntity<?> getAll(
            @PageableDefault Pageable pageable,
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) Integer totalPrice,
            @RequestParam(required = false) LocalDate checkIn,
            @RequestParam(required = false) LocalDate checkOut) {
        return Response.renderJSON(orderAccommodationService.getAll(pageable, userId, totalPrice, checkIn, checkOut), "SHOW ALL ORDER ACCOMMODATION");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(
            @PathVariable String id) {
        return Response.renderJSON(orderAccommodationService.getOne(id), "SHOW ONE ORDER ACCOMMODATION");
    }
}