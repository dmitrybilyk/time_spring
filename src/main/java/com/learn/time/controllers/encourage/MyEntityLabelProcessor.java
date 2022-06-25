package com.learn.time.controllers.encourage;

import com.learn.time.encourage.model.Label;
import com.learn.time.encourage.model.TagEvent;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyEntityLabelProcessor implements RepresentationModelProcessor<EntityModel<Label>> {

	@Override
	public EntityModel<Label> process(EntityModel<Label> model) {
		return EntityModel.of(model.getContent());
	}

}
