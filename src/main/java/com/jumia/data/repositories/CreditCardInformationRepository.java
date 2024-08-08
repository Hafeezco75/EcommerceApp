package com.jumia.data.repositories;

import com.jumia.data.models.CreditCardInformation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardInformationRepository extends MongoRepository<CreditCardInformation, String> {
}
