package com.learn.time.spring.lifecycle;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanPostProcessor;


@Data
@Getter
//@Setter
public class Student implements BeanPostProcessor {
    private String name;

//    @Autowired
//    @Qualifier("book2")
    private Book book2;

//    public Student(Book book2) {
//        this.book2 = book2;
//    }

    @Override
    public Object postProcessBeforeInitialization(@NotNull Object bean, @NotNull String beanName) throws BeansException {
        System.out.println(" some code");
        return bean;
    }

    public Student() {
        String s = "dfd";
//        1
    }

    public void setName(String name) {
        this.name = name;
//        2
    }

    @Override
    public Object postProcessAfterInitialization(@NotNull Object bean, @NotNull String beanName) throws BeansException {
        return bean;
//        4
    }

    private void initStudent() {
        String s = "dfd";
//        3
    }

    public String getName() {
        return name;
    }

    private void destroyStudent() {
        String s = "dfd";
    }










}
