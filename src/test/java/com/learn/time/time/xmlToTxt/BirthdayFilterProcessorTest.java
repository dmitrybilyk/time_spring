package com.learn.time.time.xmlToTxt;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.Callable;

import com.learn.time.time.TimeApplication;
import com.learn.time.time.batch.xmltotxt.configuration.BirthdayFilterProcessor;
import com.learn.time.time.batch.xmltotxt.configuration.CustomerReportJobConfig;
import com.learn.time.time.batch.xmltotxt.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.test.MetaDataInstanceFactory;
import org.springframework.batch.test.StepScopeTestExecutionListener;
import org.springframework.batch.test.StepScopeTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

/**
 * Tests for {@link BirthdayFilterProcessor}.
 *
 * @author Alexey Saenko (alexey.saenko@gmail.com)
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBatchTest
@EnableAutoConfiguration
@ContextConfiguration(classes = { CustomerReportJobConfig.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class BirthdayFilterProcessorTest {

    @Autowired
    private BirthdayFilterProcessor processor;

    public StepExecution getStepExecution() {
//        log.info("getting step execution");
        return MetaDataInstanceFactory.createStepExecution();
    }

    @Test
    public void filter() throws Exception {
        final Customer customer = new Customer();
        customer.setId(1);
        customer.setName("name");
        customer.setBirthday(new GregorianCalendar());
        Assert.assertNotNull(processor.process(customer));
    }

    @Test
    public void filterId() throws Exception {
        final Customer customer = new Customer();
        customer.setId(1);
        customer.setName("name");
        customer.setBirthday(new GregorianCalendar());
        final int id = StepScopeTestUtils.doInStepScope(
            getStepExecution(),
            () -> processor.process(customer).getId()
        );
        Assert.assertEquals(1, id);
    }

}