package com.jumia;

import com.mongodb.client.MongoClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

//@EnableMongoRepositories
@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }
    //record UserController(ResponseEntity<?> registerUser, ResponseEntity<?> loginUser) {}


//    @Bean
//    public MongoTemplate mongoTemplate() {
//        return new MongoTemplate(new SimpleMongoDbFactory(new MongoClient(), "Jumia"));
//    }

}