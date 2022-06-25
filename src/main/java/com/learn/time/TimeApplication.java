package com.learn.time;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@SpringBootApplication
@EnableJpaRepositories(basePackages="com.learn.time.repositories")
@EnableTransactionManagement
public class TimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimeApplication.class, args);
	}

	@Value("${baeldung.api.path}")
	String contextPath;

	@Bean
	ServletRegistrationBean servletRegistrationBean() {
		ServletRegistrationBean servlet = new ServletRegistrationBean
				(new CamelHttpTransportServlet(), contextPath+"/*");
		servlet.setName("CamelServlet");
		return servlet;
	}
}
