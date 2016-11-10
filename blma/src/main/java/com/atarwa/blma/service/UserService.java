package com.atarwa.blma.service;

import com.atarwa.blma.model.User;

public interface UserService {
	User findUserById(int id);
    User findUserByUserName(String userName);
}
