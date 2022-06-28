package com.learn.time.camel.rest;

import com.learn.time.model.User;
import org.springframework.stereotype.Component;

@Component
public class ServiceBean {
    public User response(User user) {
        user.setName(user.getName().toUpperCase());
        return user;
    }
    
}