package com.jumia.services;

import com.jumia.data.models.PaymentOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PaymentOrderServiceImplTest {
    @Autowired
    private PaymentOrderService paymentOrderService;


    @Test
    public void testThatUserCanMakePaymentOrder() {
        PaymentOrder paymentOrder = new PaymentOrder();
    }
}
