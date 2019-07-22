package com.ubv;

import java.util.Date;

import com.ubv.entity.Address;
import com.ubv.entity.Phone;
import com.ubv.entity.PhoneNetwork;
import com.ubv.entity.User;
import com.ubv.service.UserService;

public class App {
	public static void main(String[] args) {

		saveUser();
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
		a.setStreet("Strada 1");
		a.setUsers(u);

		u.setAddress(a);

		UserService us = new UserService();
		us.persist(u);

	}
}
