package com.learn.time.time.xmlToTxt;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.Callable;

import com.learn.time.time.TimeApplication;
import com.learn.time.time.batch.xmltotxt.configuration.BirthdayFilterProcessor;
import com.learn.time.time.batch.xmltotxt.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.test.MetaDataInstanceFactory;
import org.springframework.batch.test.StepScopeTestExecutionListener;
import org.springframework.batch.test.StepScopeTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

/**
 * Tests for {@link BirthdayFilterProcessor}.
 *
 * @author Alexey Saenko (alexey.saenko@gmail.com)
 */
@Slf4j
@RunWith(SpringRunner.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, StepScopeTestExecutionListener.class})
@ContextConfiguration(classes = {TimeApplication.class, BatchTestConfiguration.class})
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