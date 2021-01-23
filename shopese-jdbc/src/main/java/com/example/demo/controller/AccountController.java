package com.example.demo.controller;

import com.example.demo.helper.responseBuilder.ResponseForm;
import com.example.demo.model.Account;
import com.example.demo.model.Order;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.relation.Role;

@RestController
@RequestMapping("api")
public class AccountController  extends BaseController{
    @Autowired
    AccountService accountService;

    @PostMapping(value = "/register")
    public ResponseEntity<ResponseForm<Boolean>> create(@RequestBody Account account) {
        return ResponseEntity.ok(ResponseForm.responseOk(accountService.create(account.getUsername(),account.getPassword()), 1, "ok"));
    }


}
