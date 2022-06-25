package com.learn.time.camel.encdata;

import com.zoomint.encourage.model.conversation.ConversationEvent;
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