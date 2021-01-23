package com.example.demo.repository;

import org.bouncycastle.util.encoders.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.UUID;

@Repository
@Configuration
public class AccountRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void create(String username, String password) throws Exception{
        String sql = "Insert into account(username,password) values(?,?)";
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hash =messageDigest.digest(
                password.getBytes(StandardCharsets.UTF_8)
        );
        String hashPassword = new String(Hex.encode(hash));
        jdbcTemplate.update(sql, username, hashPassword);
    }
}
