package com.ubv;

import java.util.Date;

import com.ubv.entity.Address;
import com.ubv.entity.Phone;
import com.ubv.entity.PhoneNetwork;
import com.ubv.entity.User;
import com.ubv.service.PhoneService;
import com.ubv.service.UserService;

public class App {
	public static void main(String[] args) {

//		Address address = new Address();
//		Transaction transaction = null;
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
////			// start a transaction
//			transaction = session.beginTransaction();
////			// save the student objects
//			session.save(address);
////			// commit transaction
//			transaction.commit();
////			
//		} catch (Exception e) {
//			if (transaction != null) {
//				transaction.rollback();
//			}
//			e.printStackTrace();
//		}

//		savePhone();
		saveUser();
	}

	static void savePhone() {
		PhoneService ps = new PhoneService();
		Phone p = new Phone();
		p.setCreationTimestamp(new Date(System.currentTimeMillis()));
		p.setPhoneNetwork(PhoneNetwork.DIGI);
		p.setPhoneNr("0777123456");

		ps.persist(p);

	}

	static void saveUser() {
		User u = new User();
		u.setCreationTimestamp(new Date(System.currentTimeMillis()));
		u.setName("RR");

		Phone p = new Phone();
		p.setCreationTimestamp(new Date(System.currentTimeMillis()));
		p.setPhoneNetwork(PhoneNetwork.DIGI);
		p.setPhoneNr("PhoneInUser");

		u.setPhone(p);
		p.setUser(u);

		Address a = new Address();
		a.setCreationTimestamp(new Date(System.currentTimeMillis()));
		a.setNr(715);
		a.setPostalCode(507080);
		a.setStreet("Strada");
		a.setUsers(u);

		u.setAddress(a);

		UserService us = new UserService();
		us.persist(u);

	}
}
