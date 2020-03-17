package com.chr12bu.app_framework.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.chr12bu.app_framework.model.User;


public interface UserRepository extends MongoRepository<User, String> {

	User findByEmail(String email);
}
