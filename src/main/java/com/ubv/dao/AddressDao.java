package com.ubv.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ubv.entity.Address;
import com.ubv.util.HibernateUtil;

public class AddressDao implements EntityDao<Address, Integer> {

	private Session currentSession;

	private Transaction currentTransaction;

	public AddressDao() {
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

	public void persist(Address entity) {
		getCurrentSession().save(entity);
	}

	public void update(Address entity) {
		getCurrentSession().update(entity);
	}

	public Address findById(Integer id) {
		Address address = (Address) getCurrentSession().get(Address.class, id);
		return address;
	}

	public void delete(Address entity) {
		getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<Address> findAll() {
		List<Address> addresss = (List<Address>) getCurrentSession().createQuery("from Address").list();
		return addresss;
	}

	public void deleteAll() {
		List<Address> entityList = findAll();
		for (Address entity : entityList) {
			delete(entity);
		}
	}
}
