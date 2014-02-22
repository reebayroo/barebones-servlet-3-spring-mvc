package com.reebayroo.persistence.domain;

public interface IdentifiedDomain<T> {
	boolean isNew();

	boolean isNotNew();

	T getId();
}
