package com.example.first.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.first.entity.MessageStore;

public interface MessageStoreRepo extends JpaRepository<MessageStore, String>{
	
	
}

