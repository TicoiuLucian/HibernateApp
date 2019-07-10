package com.ubv.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ubv.entity.Movie;
import com.ubv.util.HibernateUtil;

public class MovieDao implements EntityDao<Movie, Integer> {

	private Session currentSession;

	private Transaction currentTransaction;

	public MovieDao() {
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

	public void persist(Movie entity) {
		getCurrentSession().save(entity);
	}

	public void update(Movie entity) {
		getCurrentSession().update(entity);
	}

	public Movie findById(Integer id) {
		Movie movie = (Movie) getCurrentSession().get(Movie.class, id);
		return movie;
	}

	public void delete(Movie entity) {
		getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<Movie> findAll() {
		List<Movie> movies = (List<Movie>) getCurrentSession().createQuery("from Movie").list();
		return movies;
	}

	public void deleteAll() {
		List<Movie> entityList = findAll();
		for (Movie entity : entityList) {
			delete(entity);
		}
	}
}