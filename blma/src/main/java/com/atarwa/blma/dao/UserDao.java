package com.atarwa.blma.dao;

import com.atarwa.blma.model.User;

public interface UserDao {
	User findUserById(int id);
    User findUserByUserName(String userName);
}
