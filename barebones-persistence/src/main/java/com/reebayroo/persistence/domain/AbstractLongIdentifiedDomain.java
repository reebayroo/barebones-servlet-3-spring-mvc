package com.reebayroo.persistence.domain;

public abstract class AbstractLongIdentifiedDomain implements IdentifiedDomain<Long> {

	@Override
	public boolean isNew() {
		return getId() == null;
	}

	@Override
	public boolean isNotNew() {
		return !isNew();
	}


}
