package com.travelling.travelling.service;

import com.travelling.travelling.utils.dto.OrderAccDTO;
import com.travelling.travelling.utils.dto.OrderAccommodationDTO;
import com.travelling.travelling.utils.dto.Transaction;
import com.travelling.travelling.utils.response.CreateTransactionResponse;

public interface TransactionService {
    CreateTransactionResponse createOrderAccommodation(OrderAccDTO request);
    void paymentStatus(String token, String orderId, Transaction.Expiry expiry, String source);
}
