package com.chr12bu.app_framework.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.chr12bu.app_framework.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {

	Role findByRole(String role);
}
