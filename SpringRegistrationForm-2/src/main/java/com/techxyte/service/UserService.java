package com.techxyte.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techxyte.entity.Employee;
import com.techxyte.repository.UserRepository;

@Service
public class UserService {
	 @Autowired
	    private UserRepository userRepository;

	    public Employee saveUser(Employee user) {
	        return userRepository.save(user);
	    }

	    public Employee findByEmail(String email) {
	        return userRepository.findByEmail(email);
	    }

}
