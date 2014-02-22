package com.reebayroo.persistence.dao;

import com.reebayroo.persistence.domain.IdentifiedDomain;

public interface IBaseDao<T extends IdentifiedDomain> {

	public void save(T domain);
	public T load(Object id);
	public T load(Class<? extends T> claszz, Object id);
	public void remove(T domain);
	
}
