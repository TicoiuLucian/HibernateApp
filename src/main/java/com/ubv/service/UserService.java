package com.ubv.service;

import java.util.List;

import com.ubv.dao.UserDao;
import com.ubv.entity.User;

public class UserService {
	   private static UserDao userDao;
	   
	    public UserService() {
	        userDao = new UserDao();
	    }
	 
	    public void persist(User entity) {
	        userDao.openCurrentSessionwithTransaction();
	        userDao.persist(entity);
	        userDao.closeCurrentSessionwithTransaction();
	    }
	 
	    public void update(User entity) {
	        userDao.openCurrentSessionwithTransaction();
	        userDao.update(entity);
	        userDao.closeCurrentSessionwithTransaction();
	    }
	 
	    public User findById(Integer id) {
	        userDao.openCurrentSession();
	        User user = userDao.findById(id);
	        userDao.closeCurrentSession();
	        return user;
	    }
	 
	    public void delete(Integer id) {
	        userDao.openCurrentSessionwithTransaction();
	        User user = userDao.findById(id);
	        userDao.delete(user);
	        userDao.closeCurrentSessionwithTransaction();
	    }
	 
	    public List<User> findAll() {
	        userDao.openCurrentSession();
	        List<User> users = userDao.findAll();
	        userDao.closeCurrentSession();
	        return users;
	    }
	 
	    public void deleteAll() {
	        userDao.openCurrentSessionwithTransaction();
	        userDao.deleteAll();
	        userDao.closeCurrentSessionwithTransaction();
	    }
	 
	    public UserDao userDao() {
	        return userDao;
	    }
}
