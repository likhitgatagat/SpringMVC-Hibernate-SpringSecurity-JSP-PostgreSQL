package com.atarwa.blma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atarwa.blma.dao.UserDao;
import com.atarwa.blma.model.User;

@Service("userService")
@Transactional
public class UserServiceImplementation implements UserService {

	@Autowired
    private UserDao dao;

	@Override
	public User findUserById(int id) {
		return dao.findUserById(id);
	}

	@Override
	public User findUserByUserName(String userName) {
		return dao.findUserByUserName(userName);
	}

}
