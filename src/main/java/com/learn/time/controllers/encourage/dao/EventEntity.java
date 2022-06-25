package com.learn.time.controllers.encourage.dao;

import com.learn.time.encourage.model.ConversationEvent;
//import com.zoomint.encourage.common.model.CommonEntity;
//import com.zoomint.encourage.model.conversation.ConversationEvent;
import lombok.*;
import org.springframework.test.context.jdbc.Sql;
//import org.eclipse.persistence.annotations.ChangeTracking;
//import org.eclipse.persistence.descriptors.changetracking.ChangeTracker;

import javax.persistence.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

//import static org.eclipse.persistence.annotations.ChangeTrackingType.ATTRIBUTE;

@Entity
@Table(name = "events")
//@ChangeTracking(ATTRIBUTE) // this is really ugly - we should introduce weaving instead
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EventEntity {
//public class EventEntity extends CommonEntity<String> {

	@Transient
	private PropertyChangeListener changeListener;

	@Id
	@Column(name = "eventid")
	private String eventId;

	@Column(name = "eventdata", nullable = false)
	private ConversationEvent event;

	@Version
	private Integer version;

//	@Override
//	public String getId() {
//		return getEventId();
//	}
//
//	@Override
//	public void setId(String id) {
//		setEventId(id);
//	}

	public void setEvent(ConversationEvent event) {
		// hack: events are equal if they have the same ID, so they are not detected as changes by default
		changeListener.propertyChange(new PropertyChangeEvent(this, "event", null, event));
		this.event = event;
	}

	@Override
	public boolean equals(Object other) {
		return this == other || (other instanceof EventEntity && super.equals(other));
	}

	@Override
	public int hashCode() {
		return super.hashCode(); // hashing the same fields
	}
//
////	@Override
//	public PropertyChangeListener _persistence_getPropertyChangeListener() {
//		return changeListener;
//	}
//
//	@Override
//	public void _persistence_setPropertyChangeListener(PropertyChangeListener changeListener) {
//		this.changeListener = changeListener;
//	}
}
