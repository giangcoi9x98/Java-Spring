package com.example.demo.helper.mapper;

import com.example.demo.model.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account =new Account();
        account.setUsername(resultSet.getString("username"));
        account.setPassword(resultSet.getString("password"));
        return account;
    }
}
