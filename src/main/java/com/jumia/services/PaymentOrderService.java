package com.jumia.services;

import com.jumia.data.models.PaymentOrder;
import com.jumia.dtos.requests.AddPaymentOrderRequest;
import com.jumia.dtos.responses.AddPaymentOrderResponse;
import org.springframework.stereotype.Service;

@Service
public interface PaymentOrderService {

    AddPaymentOrderResponse addPayment(AddPaymentOrderRequest addPaymentOrderRequest);
}
