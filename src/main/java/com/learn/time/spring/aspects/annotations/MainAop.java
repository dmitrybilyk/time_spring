package com.learn.time.spring.aspects.annotations;

import org.springframework.stereotype.Component;

@Component
public class MainAop {
    @LogExecutionTime
    public void serve() throws InterruptedException {
        Thread.sleep(2000);
    }

    @LogExecutionTime
    public void serve2() throws InterruptedException {
        Thread.sleep(3000);
    }
}
