package com.learn.time.encourage.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;
//import org.eclipse.persistence.annotations.BatchFetch;
//import org.eclipse.persistence.annotations.BatchFetchType;
//import org.eclipse.persistence.annotations.BatchFetch;
//import org.eclipse.persistence.annotations.BatchFetchType;
import org.glassfish.jersey.internal.util.collection.Views;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.hateoas.RepresentationModel;

//import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

import static java.util.Collections.emptySet;
//import static javax.persistence.CascadeType.*;
//import static javax.persistence.GenerationType.SEQUENCE;
import static lombok.AccessLevel.PRIVATE;

//@Entity
//@Table(name = "labels")
@Builder(toBuilder = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = PRIVATE)
//@RestResource(exported = false)
public class Label implements Serializable {

//	@Id
//	@GeneratedValue(generator = "labels_seq", strategy = SEQUENCE)
//	@SequenceGenerator(name = "labels_seq", sequenceName = "labels_seq", allocationSize = 1)
	private Long labelId;
	@NotNull
//	@ReadOnlyProperty
//	@Column(updatable = false)
	private LabelType type;
	@JsonIgnore
	private String name;
	private String description;
	private String icon;
	private String dataKey;
	private String dataValue;

//	@OneToOne(cascade = ALL)
//	@JoinColumn(name = "external_recordid")
//	@BatchFetch(BatchFetchType.IN)
//	@JsonView(Views.SynchronizableEntityView.class)
//	private ExternalRecord externalRecord;

//	 Label is the owner of this relationship, so modifying this set directly modifies the relationship
//	@ManyToMany(cascade = {PERSIST, MERGE})
//	@JoinTable(name = "labels_to_phrases",
//			joinColumns = @JoinColumn(name = "labelid"),
//			inverseJoinColumns = @JoinColumn(name = "speechphraseid"))
//	@BatchFetch(BatchFetchType.IN)
//	@Singular
//	@JsonIgnoreProperties(value = "labels", allowSetters = true)
//	@JsonIgnore
//	private Set<SpeechPhrase> speechPhrases = emptySet();

//	@Override
	public void setId(Long aLong) {
		setLabelId(aLong);
	}

//	@Override
	public Long getId() {
		return getLabelId();
	}

	@Override
	public boolean equals(Object other) {
		return this == other || (other instanceof Label && super.equals(other));
	}

	@Override
	public int hashCode() {
		return super.hashCode(); // hashing the same fields
	}

	@Override
	public String toString() {
		return "Label{" + labelId + ":" + type + ":" + name
//				+ (externalRecord != null ? ":" + externalRecord : "")
				+ (description != null ? " \"" + description + "\"" : "")
				+ (icon != null ? ", icon=" + icon : "")
				+ (dataKey != null ? ", dataKey=" + dataKey + "" : "")
				+ (dataValue != null ? ", dataValue=" + dataValue + "" : "")
//				+ (speechPhrases != null && !speechPhrases.isEmpty() ? ", with " + speechPhrases.size() + " speech phrase(s)" : "")
				+ "}";
	}

//	@PreUpdate
//	@PreRemove
//	@PrePersist
//	public void checkLabelType() {
//		// should only be created/modified/deleted via flyway scripts
//		if (LabelType.DEFAULT == type) {
//			throw new UnmodifiableEntityException();
//		}
//	}
}
