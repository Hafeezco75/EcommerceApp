package com.jumia.data.repositories;

import com.jumia.data.models.PaymentOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentOrderRepository extends MongoRepository<PaymentOrder, String> {
    PaymentOrder findByOrderId(String orderId);
}
