package com.capgemini.drinkanddelight.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="distributor_entity")
public class Distributor implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String distributorId;
	private String name;
	private String Address;
	private double phoneNumber;
	
	public Distributor() {}

	
	public Distributor(String distributorId, String name, String address, double phoneNumber) {
		super();
		this.distributorId = distributorId;
		this.name = name;
		Address = address;
		this.phoneNumber = phoneNumber;
	}


	public String getDistributorId() {
		return distributorId;
	}
	public void setDistributorId(String distributorId) {
		this.distributorId = distributorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public double getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(double phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	@Override
	public String toString() {
		return "DistributorEntity [distributorId=" + distributorId + ", name=" + name + ", Address=" + Address
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	
	
}