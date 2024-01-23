package com.cdac.training.inventory.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.training.inventory.model.User;
import com.cdac.training.inventory.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional	
public class UserService {
	
	@Autowired
	private UserRepository urepo;
	
	public void saveUser(User u) {
        urepo.save(u);  // invokes save() method of JPA repo
    }
	
	public User findByEmail(String email)
	{
	 	        return urepo.findByEmail(email); // Invoke Custom Method
	    }
}
