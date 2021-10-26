package com.learn.time.time.xmlToTxt;

import com.learn.time.time.TimeApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Tests for the application.
 *
 * @author Alexey Saenko (alexey.saenko@gmail.com)
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TimeApplication.class, BatchTestConfiguration.class})
public class BatchApplicationTest {

    @Test
    public void contextLoads() {
    }

}