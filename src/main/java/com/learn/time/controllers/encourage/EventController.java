package com.learn.time.controllers.encourage;

import com.learn.time.controllers.encourage.dao.EventDao;
import com.learn.time.controllers.encourage.service.ConversationEventService;
import com.learn.time.encourage.model.EventList;
import com.learn.time.encourage.model.Label;
import com.learn.time.encourage.model.TagEvent;
import jdk.jfr.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Slf4j
@BasePathAwareController
//@RequestMapping(value = "/events")
public class EventController {
    private LabelService labelService;
    @Autowired
    private ConversationEventService service;
//    @Autowired
//    private CustomerService customerService;


    @PostMapping(path = "/events", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public EventList saveBulkEvents(@RequestBody EventList eventList) {
        service.saveEvents(eventList);
        log.debug("Save bulk events point");
//        EventList savedList = conversationEventService.saveEvents(eventList);
//
//        enrichEvents(savedList.getEvents());
//        for (ConversationEvent event : savedList.getEvents().stream().filter(conversationEvent ->
//                conversationEvent instanceof TagEvent).collect(Collectors.toList())) {
//            TagEvent tagEvent = (TagEvent) event;
//            for (Label label : tagEvent.getLabels()) {
//                linkTo(LabelController.class).slash(label.getLabelId()).withSelfRel();
//            }
//        }
        return eventList;
    }

    @PostMapping(path = "/label", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Label saveLabel(@RequestBody Label label) {
        log.debug("Save bulk events point");
//        EventList savedList = conversationEventService.saveEvents(eventList);
//
//        enrichEvents(savedList.getEvents());
//        for (ConversationEvent event : savedList.getEvents().stream().filter(conversationEvent ->
//                conversationEvent instanceof TagEvent).collect(Collectors.toList())) {
//            TagEvent tagEvent = (TagEvent) event;
//            for (Label label : tagEvent.getLabels()) {
//                linkTo(LabelController.class).slash(label.getLabelId()).withSelfRel();
//            }
//        }
        return label;
    }

    @GetMapping
    @ResponseBody
    public TagEvent getTagEvent() {
        TagEvent tagEvent = TagEvent.builder().eventId(33L).comment("some comment").label(Label.builder().labelId(51L).build()).build();
//        tagEvent.add(linkTo(EventController.class).slash(tagEvent.getId()).withSelfRel());
        return tagEvent;
    }

}