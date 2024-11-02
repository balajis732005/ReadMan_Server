package com.readman.ReadMan_Server.repository;

import com.readman.ReadMan_Server.collection.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByUserEmail(String email);

}
