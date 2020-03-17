package com.chr12bu.app_framework.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.chr12bu.app_framework.model.SomeModel;

public interface SomeModelRepository extends MongoRepository<SomeModel, String> {
	
	public SomeModel findByName(String name);

}
