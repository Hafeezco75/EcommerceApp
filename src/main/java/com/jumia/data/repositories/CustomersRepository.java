package com.jumia.data.repositories;

import com.jumia.data.models.Customers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends MongoRepository<Customers, String> {
}
