package com.learn.patterns;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("patterns/strategy/spring.xml");
		StrategyUser strategyUser = applicationContext.getBean(StrategyUser.class);
		strategyUser.processMediaFileInternally("MY CELddddUM");
	}
}
