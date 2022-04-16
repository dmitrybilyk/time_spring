package com.learn.time.repositories;

import com.learn.time.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByName(String name);

    @Modifying
    @Transactional
    @Query(value = "CALL testProcedure2();", nativeQuery = true)
    void testProcedure2();
}