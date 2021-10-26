package com.learn.time.time.batch.xmltotxt.configuration;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.learn.time.time.batch.xmltotxt.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

/**
 * Processor filters customers by being born in the actual month.
 *
 * @author Alexey Saenko (alexey.saenko@gmail.com)
 */
@Slf4j
public class BirthdayFilterProcessor implements ItemProcessor<Customer, Customer> {
    @Override
    public Customer process(final Customer item) throws Exception {
        if (new GregorianCalendar().get(Calendar.MONTH) == item.getBirthday().get(Calendar.MONTH)) {
            log.info("Customer {} matched the birthday filter", item);
            return item;
        }
        return null;
    }
}