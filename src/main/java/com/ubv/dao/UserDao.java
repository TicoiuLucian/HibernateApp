package com.ubv.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ubv.entity.User;
import com.ubv.util.HibernateUtil;

public class UserDao implements EntityDao<User, Integer> {

	private Session currentSession;

	private Transaction currentTransaction;

	public UserDao() {
	}

	public Session openCurrentSession() {
		currentSession = HibernateUtil.getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = HibernateUtil.getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}

	public void closeCurrentSession() {
		currentSession.close();
	}

	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}

	public void persist(User entity) {
		currentSession.save(entity);
	}

	public void update(User entity) {
		currentSession.update(entity);
	}

	public User findById(Integer id) {
		User user = (User) currentSession.get(User.class, id);
		return user;
	}

	public void delete(User entity) {
		currentSession.delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		List<User> users = (List<User>) currentSession.createQuery("from User").list();
		return users;
//		return currentSession.createQuery("SELECT a FROM User a", User.class).getResultList(); 
	}

	public void deleteAll() {
		List<User> entityList = findAll();
		for (User entity : entityList) {
			delete(entity);
		}
	}

}
