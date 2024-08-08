package com.jumia.data.repositories;

import com.jumia.data.models.Sellers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellersRepository extends MongoRepository<Sellers, String> {
}
