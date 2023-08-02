package com.shabbir.springMVC.project.Model.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "Students", indexes = { @Index(columnList = "Pancard_ID"), @Index(columnList = "email"),
		@Index(columnList = "phone_Number"), @Index(columnList = "Aadhar_number")})
public class StudentBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(name = "Aadhar_number", nullable = false)
	private long aadharNumber;
	@Column(unique = true)
	private String email;
	@Column(unique = true, name = "Pancard_ID")
	private String panCardNumber;
	private String address;
	@Column(length = 6)      
	private String gender;
	@Column(length = 10, name = "Marritual_Status")
	private String marritualStatus;
	@Column(name = "Date_Of_Birth")
	private String dateOfBirth;
	@Column(name = "phone_Number")
	private long phoneNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPanCardNumber() {
		return panCardNumber;
	}

	public void setPanCardNumber(String panCardNumber) {
		this.panCardNumber = panCardNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMarritualStatus() {
		return marritualStatus;
	}

	public void setMarritualStatus(String marritualStatus) {
		this.marritualStatus = marritualStatus;
	}

	

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public StudentBean() {
		super();
	}
	
	

	public StudentBean(int id, String name, long aadharNumber, String email, String panCardNumber, String address,
			String gender, String marritualStatus,String dateOfBirth, long phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.aadharNumber = aadharNumber;
		this.email = email;
		this.panCardNumber = panCardNumber;
		this.address = address;
		this.gender = gender;
		this.marritualStatus = marritualStatus;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
  	}
	@Override
	public String toString() {
		return "StudentBean [id=" + id + ", name=" + name + ", aadharNumber=" + aadharNumber + ", email=" + email
				+ ", panCardNumber=" + panCardNumber + ", address=" + address + ", gender=" + gender
				+ ", marritualStatus=" + marritualStatus + ", dateOfBirth=" + dateOfBirth + ", phoneNumber="
				+ phoneNumber + "]";
	}
}