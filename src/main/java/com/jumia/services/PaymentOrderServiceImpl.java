package com.jumia.services;

import com.jumia.data.models.PaymentOrder;
import com.jumia.data.repositories.PaymentOrderRepository;
import com.jumia.dtos.requests.AddPaymentOrderRequest;
import com.jumia.dtos.responses.AddPaymentOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PaymentOrderServiceImpl implements PaymentOrderService {
    @Autowired
    private PaymentOrderRepository paymentOrderRepository;

    public ArrayList<PaymentOrder> getPaymentOrders() {
        ArrayList<PaymentOrder> paymentOrders = new ArrayList<PaymentOrder>();
        paymentOrderRepository.findAll().forEach(paymentOrders::add);
        return paymentOrders;
    }

    @Override
    public AddPaymentOrderResponse addPayment(AddPaymentOrderRequest addPaymentOrderRequest){
        AddPaymentOrderResponse addPaymentOrderResponse = new AddPaymentOrderResponse();
        PaymentOrder paymentOrder = new PaymentOrder();
        paymentOrder.setOrderId(addPaymentOrderRequest.getOrderId());
        paymentOrder.setBillingInformation(addPaymentOrderRequest.getBillingInformation());

        return addPaymentOrderResponse;
    }
}
