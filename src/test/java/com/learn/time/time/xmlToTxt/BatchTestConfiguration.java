package com.learn.time.time.xmlToTxt;

import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Test configuration.
 *
 * @author Alexey Saenko (alexey.saenko@gmail.com)
 */
@Configuration
public class BatchTestConfiguration {
    @Bean
    public JobLauncherTestUtils jobLauncherTestUtils() {
        return new JobLauncherTestUtils();
    }
}