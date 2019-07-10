package com.ubv.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Phone")
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationTimestamp;

	@Column
	private String phoneNr;

	@Column
	@Enumerated(EnumType.STRING)
	private PhoneNetwork phoneNetwork;

	@OneToOne(mappedBy = "phone")
	private User user;

	public int getId() {
		return id;
	}

	public Date getCreationTimestamp() {
		return creationTimestamp;
	}

	public void setCreationTimestamp(Date creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	public String getPhoneNr() {
		return phoneNr;
	}

	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}

	public PhoneNetwork getPhoneNetwork() {
		return phoneNetwork;
	}

	public void setPhoneNetwork(PhoneNetwork phoneNetwork) {
		this.phoneNetwork = phoneNetwork;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
