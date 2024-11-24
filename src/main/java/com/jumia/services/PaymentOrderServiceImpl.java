package com.jumia.services;

import com.jumia.data.models.PaymentOrder;
import com.jumia.data.repositories.PaymentOrderRepository;
import com.jumia.dtos.requests.AddPaymentOrderRequest;
import com.jumia.dtos.responses.AddPaymentOrderResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class PaymentOrderServiceImpl implements PaymentOrderService {

    private final PaymentOrderRepository paymentOrderRepository;

    public ArrayList<PaymentOrder> getPaymentOrders() {
        ArrayList<PaymentOrder> paymentOrders = new ArrayList<PaymentOrder>();
        paymentOrderRepository.findAll().forEach(e -> paymentOrders.add(e));
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
