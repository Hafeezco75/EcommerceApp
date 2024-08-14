package com.jumia.data.repositories;

import com.jumia.data.models.Items;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends MongoRepository<Items, String> {

}
