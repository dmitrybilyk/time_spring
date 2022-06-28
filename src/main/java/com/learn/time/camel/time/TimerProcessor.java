package com.learn.time.camel.time;

import com.learn.time.camel.time.Timer;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;


public class TimerProcessor implements Processor {
    public void process(Exchange exchange) throws Exception {
          String id = exchange.getIn().getBody(String.class);
         Timer t = new Timer(id);
      exchange.getIn().setBody(t);
      }
}