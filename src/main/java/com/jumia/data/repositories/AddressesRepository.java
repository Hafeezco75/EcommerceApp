package com.jumia.data.repositories;

import com.jumia.data.models.Addresses;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressesRepository extends MongoRepository<Addresses, String> {
}
