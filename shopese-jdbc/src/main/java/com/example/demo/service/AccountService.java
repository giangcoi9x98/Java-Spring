package com.example.demo.service;

import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public boolean create(String username, String password) {
        try {
            accountRepository.create(username,password);
            return  true;
        } catch (Exception e) {
            System.out.println(e);
            return  false;
        }
    }

}
