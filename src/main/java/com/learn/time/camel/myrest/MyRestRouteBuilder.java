package com.learn.time.camel.myrest;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class MyRestRouteBuilder extends RouteBuilder {
	@Override
	public void configure() throws Exception {
		restConfiguration()
				.component("servlet")
				.bindingMode(RestBindingMode.json);
		rest("/testrest").get().to("bean:myRestBean?method=testMethod()");
		rest("/testrest/create").get("{id}").to("bean:myRestBean?method=testMethod(${header.id})");
		rest().path("/my-api").get()
				.outType(ResponseType.class)
				.to("bean:helloBean"); // this sends the Body to the bean
	}
}
