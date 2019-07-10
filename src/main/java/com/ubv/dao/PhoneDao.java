package com.ubv.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ubv.entity.Phone;
import com.ubv.util.HibernateUtil;

public class PhoneDao implements EntityDao<Phone, Integer> {

	private Session currentSession;

	private Transaction currentTransaction;

	public PhoneDao() {
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

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	public void persist(Phone entity) {
		getCurrentSession().save(entity);
	}

	public void update(Phone entity) {
		getCurrentSession().update(entity);
	}

	public Phone findById(Integer id) {
		Phone phone = (Phone) getCurrentSession().get(Phone.class, id);
		return phone;
	}

	public void delete(Phone entity) {
		getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<Phone> findAll() {
		List<Phone> phones = (List<Phone>) getCurrentSession().createQuery("from Phone").list();
		return phones;
	}

	public void deleteAll() {
		List<Phone> entityList = findAll();
		for (Phone entity : entityList) {
			delete(entity);
		}
	}

}
