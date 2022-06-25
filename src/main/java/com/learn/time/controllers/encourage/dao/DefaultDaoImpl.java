package com.learn.time.controllers.encourage.dao;

//import com.google.common.collect.Lists;
//import jakarta.persistence.EntityManager;
import com.google.common.collect.Lists;
import org.jetbrains.annotations.NotNull;
import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.data.jpa.repository.support.JpaEntityInformation;
//import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
//import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.EntityMetadata;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
//import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * See
 * <a href="http://docs.spring.io/spring-data/commons/docs/current/reference/html/#repositories.custom-behaviour-for-all-repositories">
 * Spring Data Commons - Reference Documentation: Adding custom behavior to all repositories</a>
 *
 * @param <E>  Entity
 * @param <PK> PrimaryKey
 */
public class DefaultDaoImpl<E, PK extends Serializable> extends SimpleJpaRepository<E, PK> implements DefaultDao<E, PK> {

	private final EntityManager entityManager;

	public DefaultDaoImpl(EntityMetadata<E> entityMetadata, EntityManager entityManager) {
		super(entityMetadata.getJavaType(), entityManager);
		this.entityManager = entityManager;
	}


	@NotNull
	@Override
	public E findUnique(@NotNull PK id) {
		return findById(id)
				.orElseThrow(() -> new EmptyResultDataAccessException("Invalid ID for " + getDomainClass().getSimpleName(), 1));
	}

	@NotNull
	@Override
	public List<E> findAllById(@NotNull Iterable<PK> pks) {
		if (!pks.iterator().hasNext()) {
			return Collections.emptyList();
		}

		JpaEntityInformation<E, ?> entityInformation =
				JpaEntityInformationSupport.getEntityInformation(getDomainClass(), entityManager);

		TypedQuery<E> query = entityManager.createQuery(
				"Select t " +
						"from " + entityInformation.getEntityName() + " t " +
						"where t." + entityInformation.getIdAttribute().getName() + " IN :param",
				getDomainClass());
		query.setParameter("param", Lists.newArrayList(pks));

		return query.getResultList();
	}
}
