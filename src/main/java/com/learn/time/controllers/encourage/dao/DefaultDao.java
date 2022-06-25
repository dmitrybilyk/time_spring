package com.learn.time.controllers.encourage.dao;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * Here define methods which will be then accessible in all repositories (daos). Implementation is needed in  DefaultDaoImpl.
 *
 * See http://docs.spring.io/spring-data/commons/docs/current/reference/html/#repositories.custom-behaviour-for-all-repositories
 * Radek Mensik, 3/2/2015
 */
@NoRepositoryBean
public interface DefaultDao<T, ID extends Serializable> extends JpaRepository<T, ID> {

	@NotNull
	T findUnique(@NotNull ID id);

	@Override
	@NotNull
	List<T> findAllById(@NotNull Iterable<ID> ids);
}
