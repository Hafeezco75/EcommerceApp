package com.jumia.data.repositories;

import com.jumia.data.models.BillingInformation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingInformationRepository extends MongoRepository<BillingInformation, String> {
}
