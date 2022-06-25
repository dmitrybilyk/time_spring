package com.learn.time.controllers.encourage.service;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
//import com.zoomint.encourage.common.model.label.Label;
//import com.zoomint.encourage.common.model.speech.SpeechPhrase;
//import com.zoomint.encourage.data.access.dao.EventDao;
//import com.zoomint.encourage.data.access.model.EventEntity;
//import com.zoomint.encourage.model.conversation.ConversationEvent;
//import com.zoomint.encourage.model.conversation.ConversationEventVisitorBase;
//import com.zoomint.encourage.model.conversation.event.*;
//import com.zoomint.keycloak.provider.api.dto.User;
import com.learn.time.controllers.encourage.dao.EventDao;
import com.learn.time.controllers.encourage.dao.EventEntity;
import com.learn.time.encourage.model.ConversationEvent;
import com.learn.time.encourage.model.EventList;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.google.common.collect.Maps.uniqueIndex;
//import static com.zoomint.encourage.model.conversation.ConversationEvent.EVENT_VERSIONING;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

@Service
@Slf4j
public class ConversationEventService {

	public static final int PARAMETER_MAX_SIZE = 500;

	private final EventDao eventDao;

//	private final EventStripper stripper = new EventStripper();

	public ConversationEventService(EventDao eventDao) {
		this.eventDao = eventDao;
	}

	public EventList getEventsByIds(List<String> eventIds) {
		@SuppressWarnings("PMD.PrematureDeclaration")
		long start = System.currentTimeMillis();
		log.trace("Looking up events by {} eventIds", eventIds.size());
		List<ConversationEvent> events = Lists.partition(eventIds, PARAMETER_MAX_SIZE).stream()
				.flatMap(list -> eventDao.findAllById(list).stream())
				.map(EventEntity::getEvent)
				.collect(toList());

		log.trace("Returning {} events ({} ms)", events.size(), System.currentTimeMillis() - start);
		return new EventList(events);
	}

	@Transactional
	public EventList saveEvents(EventList eventList) {
//		List<ConversationEvent> events = eventList.getEvents();
//		if (events == null || events.isEmpty()) {
//			log.debug("Ignoring empty update");
//			return eventList;
//		}
//
//		// load existing event entities
//		long start = System.currentTimeMillis();
//
//		log.debug("Looking up {} events to update", events.size());
//		Map<String, EventEntity> entitiesById = lookupEvents(events);
//
//		log.debug("Updating {} event entities (and creating new ones) ({} ms)", entitiesById.size(), System.currentTimeMillis() - start);
//		// save each event: create or update existing
//		Instant now = Instant.now();
//		List<EventEntity> eventEntities = events.stream()
//				.map(event -> updateAndConvertEvent(event, entitiesById, now))
////				.peek(eventEntity -> stripper.accept(eventEntity.getEvent()))
//				.collect(toList());
//
//		log.debug("Saving {} event entities, including updated ({} ms)", eventEntities.size(), System.currentTimeMillis() - start);
//		eventDao.saveAll(eventEntities);

//		log.debug("Returning {} events ({} ms)", events.size(), System.currentTimeMillis() - start);
//		return eventList;
		EventList eventList1 = new EventList(Arrays.asList(eventDao.findUnique("08e5fd25-de7d-4b32-8fdd-5142319eeb95").getEvent()));
		return eventList1;
	}

	private Map<String, EventEntity> lookupEvents(List<ConversationEvent> events) {
		Map<String, ConversationEvent> eventsById = events.stream()
				.collect(Collectors.toMap(ConversationEvent::getEventId, Function.identity(), (first, duplicate) -> {
					throw new IllegalArgumentException(String.format("Duplicate eventId found in events: %s and %s", first, duplicate));
				}));

		List<EventEntity> loadedEvents = new ArrayList<>(eventsById.keySet().size());
		Iterables.partition(eventsById.keySet(), PARAMETER_MAX_SIZE)
				.forEach(set -> loadedEvents.addAll(eventDao.findAllById(set)));
		return uniqueIndex(loadedEvents, EventEntity::getEventId);
	}

	private EventEntity updateAndConvertEvent(ConversationEvent event, Map<String, EventEntity> entitiesById, Instant newCreatedInstant) {
		EventEntity entity = entitiesById.get(event.getEventId());
		if (entity != null) {
//			if (EVENT_VERSIONING.max(event, entity.getEvent()) != event) {
//				throw new OptimisticLockingFailureException(String.format(
//						"Tried to update an event with event id: %s with an outdated version (%s < %s). Please reload the event first.",
//						event.getEventId(), event.getCreated(), entity.getEvent().getCreated()));
//			}
			entity.setEvent(event);
		} else {
			entity = EventEntity.builder()
					.eventId(event.getEventId())
					.event(event)
					.build();
		}
		entity.getEvent().setCreated(newCreatedInstant);
		return entity;
	}

	public void deleteByIdIn(List<String> eventIds) {
		if (eventIds != null && !eventIds.isEmpty()) {
			eventDao.deleteAllInBatch(eventIds);
		}
	}

	@Transactional
	public void deleteAllEvents() {
		eventDao.deleteAllInBatch();
	}

//	/**
//	 * Visitor that strips entities and leaves only ids
//	 */
//	private static class EventStripper extends ConversationEventVisitorBase {
//		@Override
//		public void visitAll(@NotNull ConversationEvent event) {
//			event.streamAllParticipants().forEach(participant -> {
//				if (participant.getUser() != null) {
//					participant.setUser(User.builder().userId(participant.getUser().getUserId()).build());
//				}
//			});
//			if (event.getCreatedBy() != null) {
//				event.setCreatedBy(User.builder().userId(event.getCreatedBy().getUserId()).build());
//			}
//		}
//
//		@Override
//		public void visit(@NotNull PhraseOccurrenceEvent event) {
//			super.visit(event);
//			if (event.getPhrase() != null) {
//				event.setPhrase(SpeechPhrase.builder().speechPhraseId(event.getPhrase().getSpeechPhraseId()).build());
//			}
//		}
//
//		@Override
//		public void visit(@NotNull TagEvent event) {
//			super.visit(event);
//			if (event.getLabels() != null && !event.getLabels().isEmpty()) {
//				event.setLabels(event.getLabels().stream()
//						.map(label -> Label.builder().labelId(label.getLabelId()).build())
//						.collect(toSet()));
//			}
//		}
//
//		@Override
//		public void visit(@NotNull ReviewEvent event) {
//			event.setQuestionnaire(null);
//			if (event.getReviewee() != null) {
//				event.setReviewee(User.builder().userId(event.getReviewee().getUserId()).build());
//			}
//			if (event.getReviewer() != null) {
//				event.setReviewer(User.builder().userId(event.getReviewer().getUserId()).build());
//			}
//		}
//
//		@Override
//		public void visit(@NotNull SurveyEvent event) {
//			event.setQuestionnaire(null);
//			if (event.getReviewee() != null) {
//				event.setReviewee(User.builder().userId(event.getReviewee().getUserId()).build());
//			}
//		}
//	}
}
