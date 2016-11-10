package com.atarwa.blma.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.atarwa.blma.model.User;

@Repository("userDao")
public class UserDaoImplementation extends AbstractDao<Integer, User> implements UserDao {
 
    public User findUserById(int id) {
        return getByKey(id);
    }
 
    @SuppressWarnings("unchecked")
    public User findUserByUserName(String userName) {
    	List<User> users = getSession().createCriteria(User.class)
    			.add(Restrictions.eq("userName", userName)).list();
    	return (users.size() > 0) ? users.get(0) : null;
    }  
}
