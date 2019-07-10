package com.ubv.service;

import java.util.List;

import com.ubv.dao.MovieDao;
import com.ubv.entity.Movie;

public class MovieService {
	   private static MovieDao movieDao;
	   
	    public MovieService() {
	        movieDao = new MovieDao();
	    }
	 
	    public void persist(Movie entity) {
	        movieDao.openCurrentSessionwithTransaction();
	        movieDao.persist(entity);
	        movieDao.closeCurrentSessionwithTransaction();
	    }
	 
	    public void update(Movie entity) {
	        movieDao.openCurrentSessionwithTransaction();
	        movieDao.update(entity);
	        movieDao.closeCurrentSessionwithTransaction();
	    }
	 
	    public Movie findById(Integer id) {
	        movieDao.openCurrentSession();
	        Movie movie = movieDao.findById(id);
	        movieDao.closeCurrentSession();
	        return movie;
	    }
	 
	    public void delete(Integer id) {
	        movieDao.openCurrentSessionwithTransaction();
	        Movie movie = movieDao.findById(id);
	        movieDao.delete(movie);
	        movieDao.closeCurrentSessionwithTransaction();
	    }
	 
	    public List<Movie> findAll() {
	        movieDao.openCurrentSession();
	        List<Movie> movies = movieDao.findAll();
	        movieDao.closeCurrentSession();
	        return movies;
	    }
	 
	    public void deleteAll() {
	        movieDao.openCurrentSessionwithTransaction();
	        movieDao.deleteAll();
	        movieDao.closeCurrentSessionwithTransaction();
	    }
	 
	    public MovieDao movieDao() {
	        return movieDao;
	    }
}
