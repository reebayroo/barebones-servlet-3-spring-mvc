package com.reebayroo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reebayroo.persistence.dao.IUserDao;
import com.reebayroo.persistence.domain.User;
import com.reebayroo.service.IUserService;
import com.reebayroo.service.dtos.UserSearchDTO;

@Service
@Transactional
public class UserService implements IUserService {

	@Autowired
	IUserDao userDao;
	
	@Override
	public User save(final User user) {
		userDao.save(user);
		return user;
	}

	@Override
	public User load(final Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> find(final UserSearchDTO searchDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
