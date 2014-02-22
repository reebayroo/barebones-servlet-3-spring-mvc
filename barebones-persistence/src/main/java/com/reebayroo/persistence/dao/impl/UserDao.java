package com.reebayroo.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.reebayroo.persistence.dao.IUserDao;
import com.reebayroo.persistence.domain.User;

@Repository
public class UserDao extends BaseDao<User> implements IUserDao{

}
