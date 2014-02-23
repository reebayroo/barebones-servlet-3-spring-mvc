package com.reebayroo.service;

import java.util.List;

import com.reebayroo.persistence.domain.User;
import com.reebayroo.service.dtos.UserSearchDTO;

public interface IUserService {

	User save(User user);
	User load(Long userId);
	List<User> find(UserSearchDTO searchDTO);

}
