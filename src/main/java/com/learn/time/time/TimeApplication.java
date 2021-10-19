package com.learn.time.time;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class TimeApplication {

	@Bean(initMethod = "migrate")
	public Flyway flyway(Environment env) {
		return new Flyway(
				Flyway.configure()
						.baselineOnMigrate(true)
						.baselineVersion("0")
						.dataSource(
								"jdbc:postgresql://" +
										env.getRequiredProperty("DATABASE_HOST") +
										":" +
										env.getRequiredProperty("DATABASE_PORT")+
										"/" +
										env.getRequiredProperty("DATABASE_NAME"),
								env.getRequiredProperty("spring.database.user"),
								env.getRequiredProperty("spring.database.password")
						)
		);
	}

	public static void main(String[] args) {
		SpringApplication.run(TimeApplication.class, args);
	}

}
