package com.techxyte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techxyte.entity.User;
import com.techxyte.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	 @Autowired
	    private UserService userService;

	    @PostMapping
	    public User createUser(@RequestBody User user, @RequestParam Double initialBalance) {
	        return userService.createUserWithAccount(user, initialBalance);
	    }

	    @PostMapping("/transfer")
	    public void transfer(@RequestParam Long fromUserId, @RequestParam Long toUserId, @RequestParam Double amount) {
	        userService.transfer(fromUserId, toUserId, amount);
	    }

}
