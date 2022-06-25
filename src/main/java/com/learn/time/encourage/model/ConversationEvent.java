package com.learn.time.encourage.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import java.net.URI;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Set;

@JsonTypeInfo(use = Id.NAME, include = As.EXISTING_PROPERTY, property = "type", visible = true)
@JsonSubTypes({
		// calls
//		@JsonSubTypes.Type(value = StartedCallEvent.class, name = ConversationEvent.STARTED_CALL),
//		@JsonSubTypes.Type(value = JoinedCallEvent.class, name = ConversationEvent.JOINED_CALL),
//		@JsonSubTypes.Type(value = LeftCallEvent.class, name = ConversationEvent.LEFT_CALL),
//		// screens
//		@JsonSubTypes.Type(value = StartedScreenEvent.class, name = ConversationEvent.STARTED_SCREEN),
//		@JsonSubTypes.Type(value = EndedScreenEvent.class, name = ConversationEvent.ENDED_SCREEN),
//		// video
//		@JsonSubTypes.Type(value = StartedVideoEvent.class, name = ConversationEvent.STARTED_VIDEO),
//		@JsonSubTypes.Type(value = EndedVideoEvent.class, name = ConversationEvent.ENDED_VIDEO),
//		// text messages
//		@JsonSubTypes.Type(value = EmailEvent.class, name = ConversationEvent.EMAIL),
//		@JsonSubTypes.Type(value = ChatEvent.class, name = ConversationEvent.CHAT),
//		// data
//		@JsonSubTypes.Type(value = MetadataEvent.class, name = ConversationEvent.METADATA),
//		@JsonSubTypes.Type(value = PhraseOccurrenceEvent.class, name = ConversationEvent.PHRASE_OCCURRENCE),
		@JsonSubTypes.Type(value = TagEvent.class, name = ConversationEvent.TAG),
//		@JsonSubTypes.Type(value = ReviewEvent.class, name = ConversationEvent.REVIEW),
//		@JsonSubTypes.Type(value = SurveyEvent.class, name = ConversationEvent.SURVEY),
//		//overrides
//		@JsonSubTypes.Type(value = DeleteEvent.class, name = ConversationEvent.DELETE),
//		//modification of history
//		@JsonSubTypes.Type(value = AnonymizeEvent.class, name = ConversationEvent.ANONYMIZE),
})
public interface ConversationEvent {

	String STARTED_CALL = "STARTED_CALL";
	String JOINED_CALL = "JOINED_CALL";
	String LEFT_CALL = "LEFT_CALL";
	String STARTED_SCREEN = "STARTED_SCREEN";
	String ENDED_SCREEN = "ENDED_SCREEN";
	String EMAIL = "EMAIL";
	String CHAT = "CHAT";
	String METADATA = "METADATA";
	String PHRASE_OCCURRENCE = "PHRASE_OCCURRENCE";
	String TAG = "TAG";
	String DELETE = "DELETE";
	String REVIEW = "REVIEW";
	String SURVEY = "SURVEY";
	String ANONYMIZE = "ANONYMIZE";
	String STARTED_VIDEO = "STARTED_VIDEO";
	String ENDED_VIDEO = "ENDED_VIDEO";

//	void accept(ConversationEventVisitor visitor);

	String getType();

	/**
	 * (Optional) Correlation IDs used to group events together. Not unique per event.
	 * Each such ID should consist of the following 4 parts separated by colon {@code :}<ol>
	 *     <li>external system name from DB <strong>or</strong> {@value #CORRELATION_ID_GLOBAL}</li>
	 *     <li>external system type, such as "callrec"</li>
	 *     <li>ID namespace within the system</li>
	 *     <li>ID value</li>
	 * </ol>
	 * The first 3 values themselves must not contain colon {@code :}.
	 * The whole correlation ID should be a valid {@link URI}.
	 * Correlation IDs should be lowercase (or will be converted to lowercase automatically when saved).
	 *
	 * @return a set of Strings matching the specified format, can be empty, never null;
	 *     legacy values might not match the format
	 */
	Set<String> getCorrelationIds();

	void setCorrelationIds(Set<String> correlationIds);

	/**
	 * (Optional) Start of the event. If the event has no duration, then this is also the end of the event.
	 *
	 * @return ISO8601 timestamp with timezone, of when the event actually occurred (not recorded)
	 */
	ZonedDateTime getStart();

	void setStart(ZonedDateTime start);

	/**
	 * (Optional) Resource to which the event is related, usually implies actual media, such as call recording.
	 * Specified resource must appear in at least one {@link MediaEvent} in a conversation.
	 */
//	ConversationResource getResource();
//
//	void setResource(ConversationResource resource);

	/**
	 * (Optional) The primary participant of the conversation that caused this event to occur.
	 * E.g. whoever send the email (not recipient), written the chat message, etc.
	 * See {@link #streamAllParticipants()} for possible other participants.
	 *
	 * @return primary participant of the event, if any; could be null for events without a primary participant
	 */
//	ConversationParticipant getParticipant();
//
//	void setParticipant(ConversationParticipant participant);

	/**
	 * When this event representation was first created.
	 * The actual event occurrence time could be different - see {@link #getStart()}.
	 *
	 * @return UTC timestamp, should not be null for new events, could be null for legacy events
	 */
	Instant getCreated();

	void setCreated(Instant created);

	/**
	 * The user that created this event representation.
	 * This could be a system user, such as an importer importing this event.
	 *
	 * @return user with at least userId filled out, could be null for legacy events
	 */
//	User getCreatedBy();
//
//	void setCreatedBy(User createdBy);

	/**
	 * All participants of the event, including both primary and secondary participants.
	 * E.g., for an email this includes the sender and all recipients in all of the recipient fields: To, CC, BCC.
	 *
	 * @return a stream with all participants in the event, can be empty, never null
	 */
//	@JsonIgnore
//	@NotNull
//	default Stream<ConversationParticipant> streamAllParticipants() {
//		return getParticipant() == null ? Stream.empty() : Stream.of(getParticipant());
//	}

	/**
	 * Unique ID of the event. There should never be two events with the same ID.
	 * When an event is saved, it will overwrite existing event with the same ID, if any.
	 *
	 * @return an event ID, which can be a String in any format, such as UUID or correlationId format.
	 */
	String getEventId();

	void setEventId(String eventId);

	/**
	 * (Optional) ID of the previous representation of this event.
	 * An event referenced via this field is considered obsolete and is kept as a "historic" view of the data,
	 * it should be ignored for all other purposes, such as generating search index.
	 *
	 * @return {@link #getEventId() event ID} of the replaced event
	 */
	String getPreviousId();

	void setPreviousId(String previousId);

}
