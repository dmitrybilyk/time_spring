package com.learn.time.encourage.model;

import org.jetbrains.annotations.NotNull;

public enum LabelType {
	/**
	 * Labels that must already exist when the system is installed, and cannot be deleted.
	 */
	DEFAULT("D"),
	/**
	 * Labels created by users and used by users to add to conversations as part of a remark.
	 */
	REMARK("R"),
	/**
	 * Labels created by speech engine that group together some speech phrases.
	 */
	SPEECH_TAG("S");

	private final String dbValue;

	LabelType(String dbValue) {
		this.dbValue = dbValue;
	}

	@NotNull
	public String getDbValue() {
		return dbValue;
	}
}
