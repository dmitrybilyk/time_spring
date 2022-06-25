package com.learn.time.encourage.model;

import lombok.*;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * User has attached a tag and/or comment to the conversation.
 */
@Getter
@Setter
public class TagEvent extends ConversationEventBase {

	private Long id;
	@NonNull
	@RestResource(exported = false)
	private Set<Label> labels = new HashSet<>();
	@Size(max = 1000)
	private String comment;
	@Setter(AccessLevel.NONE)
	private Instant createdObsolete;

	@Builder
	public TagEvent(Long eventId, @Singular @NonNull Set<Label> labels, String comment) {
		super(ConversationEvent.TAG);
		this.id = eventId;
		this.labels = labels;
		this.comment = comment;
		setEventId("tag:" + eventId);
	}


}
