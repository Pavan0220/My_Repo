package com.techxyte.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techxyte.entity.Account;
import com.techxyte.entity.User;
import com.techxyte.exception.InsufficientBalanceException;
import com.techxyte.repository.AccountRepository;
import com.techxyte.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	 @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private AccountRepository accountRepository;

	    @Transactional
	    public User createUserWithAccount(User user, Double initialBalance) {
	        User savedUser = userRepository.save(user);
	        Account account = new Account();
	        account.setUserId(savedUser.getId());
	        account.setBalance(initialBalance);
	        accountRepository.save(account);
	        return savedUser;
	    }

	    @Transactional
	    public void transfer(Long fromUserId, Long toUserId, Double amount) {
	        Account fromAccount = accountRepository.findByUserId(fromUserId);
	        Account toAccount = accountRepository.findByUserId(toUserId);

	        if (fromAccount.getBalance() < amount) {
	            throw new InsufficientBalanceException("Insufficient balance in the account of user with ID " + fromUserId);
	        }

	        fromAccount.setBalance(fromAccount.getBalance() - amount);
	        toAccount.setBalance(toAccount.getBalance() + amount);

	        accountRepository.save(fromAccount);
	        accountRepository.save(toAccount);
	    }
	}
	


