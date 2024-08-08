package com.jumia.data.repositories;

import com.jumia.data.models.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<Users, String> {
    Users findByPhoneNumber(String phoneNumber);
    Users findByEmail(String email);
}
