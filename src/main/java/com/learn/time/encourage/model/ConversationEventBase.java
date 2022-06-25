package com.learn.time.encourage.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

import static java.lang.System.identityHashCode;
import static lombok.AccessLevel.NONE;

@Getter
@Setter
public abstract class ConversationEventBase implements ConversationEvent, Serializable {

	@NonNull
	private Set<String> correlationIds = new HashSet<>();
	private ZonedDateTime start;
	@Setter(NONE)
	private String type;
	private Instant created;
	private String eventId;
	private String previousId;

	protected ConversationEventBase(String type) {
		this.type = type;
	}

	protected ConversationEventBase(String type, String eventId, String previousId, @NonNull Set<String> correlationIds,
									Instant created, ZonedDateTime start) {

		this.correlationIds = correlationIds;
		this.start = start;
		this.type = type;
		this.created = created;
		this.eventId = eventId;
		this.previousId = previousId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		return o instanceof ConversationEvent
				&& eventId != null
				&& eventId.equals(((ConversationEventBase) o).eventId);
	}

	@Override
	public int hashCode() {
		return eventId != null ? eventId.hashCode() : identityHashCode(this);
	}

	@Override
	public String toString() {
		return "ConversationEvent{" + getType() + "@" + getStart() +
				(getEventId() != null ? ", eventId=" + getEventId() : "") +
				(getPreviousId() != null ? ", previousId=" + getPreviousId() : "") +
				(getCorrelationIds() != null ? ", correlationIds=" + getCorrelationIds() : "") +
				(getCreated() != null ? ", created=" + getCreated() : "") +
				"}";
	}
}
