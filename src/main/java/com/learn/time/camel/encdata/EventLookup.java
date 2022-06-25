package com.learn.time.camel.encdata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Singular;

import java.beans.ConstructorProperties;
import java.util.List;

import static com.google.common.base.MoreObjects.firstNonNull;
import static java.util.Collections.emptyList;

@Data
public final class EventLookup {
	@NonNull
	private final List<String> eventIds;

	@Builder
	@ConstructorProperties({"eventIds"})
	private EventLookup(@Singular List<String> eventIds) {
		this.eventIds = firstNonNull(eventIds, emptyList());
	}

	@JsonIgnore
	public boolean isEmpty() {
		return eventIds.isEmpty();
	}
}
