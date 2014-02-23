package com.reebayroo.persistence.dao.impl;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rebayroo.persistence.config.AbstractTransactionalTest;
import com.reebayroo.persistence.dao.IUserDao;
import com.reebayroo.persistence.domain.User;

public class UserDaoTest extends AbstractTransactionalTest {

	@Autowired
	IUserDao userDao;

	@Test
	public void simpleSave() {

		final User user = new User();
		user.setRawPassword("PASS");
		user.setLogin("mylogin");
		user.setLastName("last");
		user.setFirstName("first");
		assertTrue(user.isNew());
		userDao.save(user);
		assertFalse(user.isNew());

	}

	@Test
	public void simpleFindAll() {

		final User user = new User();
		user.setRawPassword("PASS");
		user.setLogin("mylogin");
		user.setLastName("last");
		user.setFirstName("first");
		assertTrue(user.isNew());
		userDao.save(user);
		assertFalse(user.isNew());
		assertThat(userDao.findAll(), hasItem(user));
	}

	@Test
	public void simpleLoad() {
		final User user = new User();
		user.setRawPassword("PASS");
		user.setLogin("mylogin");
		user.setLastName("last");
		user.setFirstName("first");
		
		assertTrue(user.isNew());
		userDao.save(user);
		assertFalse(user.isNew());
		assertEquals(userDao.load(user.getId()), user);
	}
}
