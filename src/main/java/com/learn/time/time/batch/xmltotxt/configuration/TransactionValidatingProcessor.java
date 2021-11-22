//package com.learn.time.time.batch.xmltotxt.configuration;
//
//import com.learn.time.time.batch.xmltotxt.model.Customer;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.item.validator.ValidatingItemProcessor;
//import org.springframework.batch.item.validator.ValidationException;
//
///**
// * Processor filters customers by the amount of transactions.
// *
// * @author Alexey Saenko (alexey.saenko@gmail.com)
// */
//@Slf4j
//public class TransactionValidatingProcessor extends ValidatingItemProcessor<Customer> {
//    public TransactionValidatingProcessor(final int limit) {
//        super(
//            item -> {
//                if (item.getTransactions() >= limit) {
//                    throw new ValidationException("Customer has more than " + limit + " transactions");
//                }
//                log.info("Customer {} matched the transaction filter", item);
//            }
//        );
//        setFilter(true);
//    }
//}