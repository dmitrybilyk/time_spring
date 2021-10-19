package com.learn.time.time.controllers;

import com.learn.time.time.model.TestUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class TimeController {
    @RequestMapping(value = "get")
    public TestUser getTest() {
        return new TestUser("userName", 22);
    }
}
