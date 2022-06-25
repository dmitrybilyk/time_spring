package com.learn.time.controllers.encourage;

import com.learn.time.encourage.model.TagEvent;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyEntityProcessor implements RepresentationModelProcessor<EntityModel<TagEvent>> {

	@Override
	public EntityModel<TagEvent> process(EntityModel<TagEvent> model) {
		return EntityModel.of(model.getContent());
	}

}
