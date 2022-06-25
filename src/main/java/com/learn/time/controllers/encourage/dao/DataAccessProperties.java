package com.learn.time.controllers.encourage.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.ZoneId;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
@Validated
@ConfigurationProperties("data")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataAccessProperties {

	@NotNull
	private Integer port = 8083;
	@NotNull
	@Valid
	private DatabaseProperties database = new DatabaseProperties();
	/**
	 * Queue for saving new conversations. This queue is persistent and all messages will be processed eventually.
	 */
	@NotEmpty
	private String conversationCorrelateQueue = "conversations-to-correlate";
	@NotNull
	@Valid
	private DisplayOptionsProperties displayOptions = new DisplayOptionsProperties();

	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class DatabaseProperties {
		@NotNull
		private Database type = Database.POSTGRESQL;
		@NotEmpty
		private String driver = "org.postgresql.Driver";
		@NotEmpty
		private String address = "jdbc:postgresql://10.17.1.58:5432/encourage";
		private String username = "encourage";
		private String password = "encourage";
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class DisplayOptionsProperties {
		@NotNull
		private ZoneId timezone = ZoneId.systemDefault();
		@NotNull
		private Map<String, String> resourceLinks = new LinkedHashMap<>();
	}
}
