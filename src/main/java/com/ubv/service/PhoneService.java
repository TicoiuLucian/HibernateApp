package com.ubv.service;

import java.util.List;

import com.ubv.dao.PhoneDao;
import com.ubv.entity.Phone;

public class PhoneService {
	   private static PhoneDao phoneDao;
	   
	    public PhoneService() {
	        phoneDao = new PhoneDao();
	    }
	 
	    public void persist(Phone entity) {
	        phoneDao.openCurrentSessionwithTransaction();
	        phoneDao.persist(entity);
	        phoneDao.closeCurrentSessionwithTransaction();
	    }
	 
	    public void update(Phone entity) {
	        phoneDao.openCurrentSessionwithTransaction();
	        phoneDao.update(entity);
	        phoneDao.closeCurrentSessionwithTransaction();
	    }
	 
	    public Phone findById(Integer id) {
	        phoneDao.openCurrentSession();
	        Phone phone = phoneDao.findById(id);
	        phoneDao.closeCurrentSession();
	        return phone;
	    }
	 
	    public void delete(Integer id) {
	        phoneDao.openCurrentSessionwithTransaction();
	        Phone phone = phoneDao.findById(id);
	        phoneDao.delete(phone);
	        phoneDao.closeCurrentSessionwithTransaction();
	    }
	 
	    public List<Phone> findAll() {
	        phoneDao.openCurrentSession();
	        List<Phone> phones = phoneDao.findAll();
	        phoneDao.closeCurrentSession();
	        return phones;
	    }
	 
	    public void deleteAll() {
	        phoneDao.openCurrentSessionwithTransaction();
	        phoneDao.deleteAll();
	        phoneDao.closeCurrentSessionwithTransaction();
	    }
	 
	    public PhoneDao phoneDao() {
	        return phoneDao;
	    }
}
