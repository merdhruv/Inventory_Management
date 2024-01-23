package com.cdac.training.inventory.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.training.inventory.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	//Custom Method - Fetch record/object based on email - non Id field
		public User findByEmail(String email);
}
