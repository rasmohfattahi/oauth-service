package com.mft.general.repository.impl;

import com.mft.general.entities.BaseEntity;
import com.mft.general.repository.GenericRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

public abstract class GenericRepositoryDefault<T extends BaseEntity<PK>, PK extends Serializable>
		implements GenericRepository<T, PK> {

	protected Class<T> domainClass = getDomainClass();

	protected String domainClassName = getDomainClass().getName();

	protected abstract Class<T> getDomainClass();

	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}
}