package com.reebayroo.persistence.util;

public class Cast {

	@SuppressWarnings("unchecked")
	public static <T> T cast(Object object){
		return (T) object;
	}
}
