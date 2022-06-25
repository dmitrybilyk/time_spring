package com.learn.time.controllers.encourage;

import com.learn.time.encourage.model.Label;
import com.learn.time.encourage.model.TagEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/labels")
public class LabelController {
    @Autowired
    private LabelService labelService;

    @GetMapping(value = "/{eventId}/labels", produces = { "application/hal+json" })
    public List<Label> getLabelsForEvent(@PathVariable final Long eventId) {
        final List<Label> labels = labelService.getAllLabelsForEvent(eventId);
//        for (final Label label : labels) {
//            final Link selfLink = linkTo(
//                    methodOn(LabelController.class).getLabelById(eventId, label.getLabelId())).withSelfRel();
//            label.add(selfLink);
//        }

//        Link link = linkTo(methodOn(LabelController.class).getLabelsForEvent(eventId)).withSelfRel();
//        CollectionModel<Label> result = CollectionModel.of(labels, link);
        return labels;
//        return result;
    }

    @GetMapping("/{eventId}/{labelId}")
    public Label getLabelById(@PathVariable final Long eventId, @PathVariable final Long labelId) {
        return labelService.getLabelByIdForEvent(eventId, labelId);
    }

    @GetMapping
    public Label getAllLabels() {
        return labelService.getAllLabels();
    }
}