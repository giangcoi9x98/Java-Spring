package com.example.demo.controller;

import org.bouncycastle.util.encoders.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
@Configuration
public abstract class BaseController {

    String hashPw;
    @ModelAttribute("BeforeRequest")
    public  void beforeRequest(HttpServletRequest request, HttpServletResponse response){
        String name ="giang";
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[]hash=digest.digest(
                   name.getBytes(StandardCharsets.UTF_8)
            );
            hashPw = new String(Hex.encode(hash));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
