package com.learn.time.controllers.encourage.dao;

//import com.zoomint.encourage.data.access.model.EventEntity;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventDao extends DefaultDao<EventEntity, String> {

	@Modifying
	@Query("delete from EventEntity where eventId in :eventIds")
	void deleteAllInBatch(@Param("eventIds") List<String> eventIds);

}
