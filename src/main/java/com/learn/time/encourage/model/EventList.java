package com.learn.time.encourage.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Singular;
import org.jetbrains.annotations.NotNull;

import java.beans.ConstructorProperties;
import java.util.List;

@Data
public class EventList {
	@NotNull
	private final List<ConversationEvent> events;

	@Builder
	@ConstructorProperties("events")
	public EventList(@NonNull @Singular List<ConversationEvent> events) {
		this.events = events;
	}
}
