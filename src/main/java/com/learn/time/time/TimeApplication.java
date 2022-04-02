package com.learn.time.time;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@SpringBootApplication
@EnableJpaRepositories(basePackages="com.learn.time.time.batch.importxmltodb.repositories")
@EnableTransactionManagement
public class TimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimeApplication.class, args);
	}
}
