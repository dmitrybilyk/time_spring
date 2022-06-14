package com.learn.time.spring.lifecycle;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//@Getter
//@Setter
@Configuration
public class Book {
//    @Value("dfdsfsdfsdf")
    @Value("${myBookName}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
