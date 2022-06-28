package com.learn.time.camel.rest;

import com.learn.time.camel.time.Timer;
import com.learn.time.camel.time.TimerProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;


//@Component
public class RestRoute extends RouteBuilder {
  JacksonDataFormat jsonDataFormat = new JacksonDataFormat(Timer.class);
  @Override
  public void configure() throws Exception {
    restConfiguration().host("localhost").port(8083);
    from("timer:timer1?period={{timer.period}}").setHeader("id", simple("${random(6,9)}"))
        .to("rest:get:random/{id}").log("${body}");
    from("timer://timer2?period={{timer.period}}").setBody().simple("Current time is ${header.firedTime}")
        .process(new TimerProcessor()).marshal(jsonDataFormat).to("rest:post:time").log("${body}");
  }
}