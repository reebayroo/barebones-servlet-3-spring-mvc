package com.reebayroo.persistence.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.reebayroo.persistence.dao.IBaseDao;
import com.reebayroo.persistence.domain.IdentifiedDomain;
import com.reebayroo.persistence.util.Cast;

public class BaseDao< T extends IdentifiedDomain<?>> implements IBaseDao<T> {

	protected Class<T> entityClass;

	protected EntityManager entityManager;

	public BaseDao() {
		final ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = Cast.cast(genericSuperclass.getActualTypeArguments()[0]);
	}

	@PersistenceContext
	public void setEntityManager(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void save(final T entity) {
		if (entity.isNew()) {
			entityManager.persist(entity);
		} else {
			entityManager.merge(entity);
		}

	}

	@Override
	public T load(final Object id) {
		return entityManager.find(entityClass, id);
	}

	@Override
	public T load(final Class<? extends T> clazz, final Object id) {
		return entityManager.find(clazz, id);
	}

	@Override
	public void remove(final T entity) {
		entityManager.remove(entity);
	}

	@Override
	public void flush() {
		entityManager.flush();
	}

	@Override
	public void clear() {
		entityManager.clear();
	}

	@Override
	public List<T> findAll() {
		final Query query = entityManager.createQuery(String.format("SELECT h FROM %s h", entityClass.getName()));
		final Object res = query.getResultList();
		return Cast.cast(res);
	}

}
