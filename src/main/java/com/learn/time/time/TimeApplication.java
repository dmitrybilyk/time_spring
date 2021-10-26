package com.learn.time.time;

import com.learn.time.time.batch.xmltotxt.configuration.CustomerReportJobConfig;
import com.learn.time.time.batch.xmltotxt.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;

@Slf4j
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
		prepareTestData(1000);
		SpringApplication.run(TimeApplication.class, args);
	}


	private static void prepareTestData(final int amount) {
		final int actualYear = new GregorianCalendar().get(Calendar.YEAR);
		final Collection<Customer> customers = new LinkedList<>();
		for (int i = 1; i <= amount; i++) {
			final Calendar birthday = new GregorianCalendar();
			birthday.set(Calendar.YEAR, random(actualYear - 100, actualYear));
			birthday.set(Calendar.DAY_OF_YEAR, random(1, birthday.getActualMaximum(Calendar.DAY_OF_YEAR)));
			final Customer customer = new Customer();
			customer.setId(i);
			customer.setName(UUID.randomUUID().toString().replaceAll("[^a-z]", ""));
			customer.setBirthday(birthday);
			customer.setTransactions(random(0, 100));
			customers.add(customer);
		}
		try (final XMLEncoder encoder = new XMLEncoder(new FileOutputStream(CustomerReportJobConfig.XML_FILE))) {
			encoder.writeObject(customers);
		} catch (final FileNotFoundException e) {
			log.error(e.getMessage(), e);
			System.exit(-1);
		}
	}

	private static int random(final int start, final int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}
}
