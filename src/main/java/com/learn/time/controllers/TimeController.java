package com.learn.time.controllers;

import com.learn.time.model.TestUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
@Slf4j
public class TimeController {

    @Value("${my.property}")
    private String myProperty;


    @RequestMapping(value = "get")
    public TestUser getTest() {
        log.info(myProperty);
        return new TestUser("userName", 22);
    }
}
