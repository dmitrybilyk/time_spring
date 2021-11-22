//package com.learn.time.time.batch.xmltotxt.configuration;
//
//import java.io.Closeable;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.io.PrintWriter;
//import java.util.List;
//import javax.annotation.PreDestroy;
//
//import com.learn.time.time.batch.xmltotxt.model.Customer;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.item.ItemWriter;
//
///**
// * Customer item writer.
// *
// * @author Alexey Saenko (alexey.saenko@gmail.com)
// */
//@Slf4j
//public class CustomerItemWriter implements ItemWriter<Customer>, Closeable {
//    private final PrintWriter writer;
//
//    public CustomerItemWriter() {
//        OutputStream out;
//        try {
//            out = new FileOutputStream("output.txt");
//        } catch (FileNotFoundException e) {
//            out = System.out;
//        }
//        this.writer = new PrintWriter(out);
//    }
//
//    @Override
//    public void write(final List<? extends Customer> items) throws Exception {
//        for (Customer item : items) {
//            writer.println(item.toString());
//        }
//    }
//
//    @PreDestroy
//    @Override
//    public void close() throws IOException {
//        writer.close();
//    }
//}