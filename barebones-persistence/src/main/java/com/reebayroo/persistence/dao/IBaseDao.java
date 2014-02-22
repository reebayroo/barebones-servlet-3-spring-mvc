package com.reebayroo.persistence.dao;

import java.util.List;

import com.reebayroo.persistence.domain.IdentifiedDomain;

public interface IBaseDao<T extends IdentifiedDomain<?>> {

	public void save(T entity);

	public T load(Object id);

	public T load(Class<? extends T> claszz, Object id);

	public void remove(T entity);

	void clear();

	void flush();

	List<T> findAll();

}
