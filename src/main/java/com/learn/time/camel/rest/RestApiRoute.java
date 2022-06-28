package com.learn.time.camel.rest;

import com.learn.time.model.User;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class RestApiRoute extends RouteBuilder {
	@Override
	public void configure() throws Exception {
		restConfiguration().component("servlet").bindingMode(RestBindingMode.auto);
		// Define REST Endpoints
		rest().path("/rest").consumes("application/json").produces("application/json")
				.get().to("direct:hello")
				.post().type(User.class).outType(User.class)
				.to("bean:serviceBean");
		from("direct:hello").transform().constant("Hello World");
	}
}
