package com.learn.time.camel.myrest;

import org.springframework.stereotype.Component;

@Component
public class MyRestBean {
	public void testMethod() {
		System.out.println("some test method");
	}
	public void testMethod(String id) {
		System.out.println("some test method " + id);
	}
}
