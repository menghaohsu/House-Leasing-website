package com.paul.spring.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="applytable")
public class Apply {
	
	@Id
	@GeneratedValue
	@Column(name = "applyID", unique=true, nullable = false)
	private int applyID;
	
	@Column(name="title")
	private String title;
	
	@Column(name="address")
	private String address;
	
	@Column(name="bedrooms")
	private int bedrooms;
	
	@Column(name="bathrooms")
	private int bathrooms;
	
	@Column(name="livingrooms")
	private int livingrooms;
	
	@Column(name="accommodate")
	private int accommodate;
	
	@Column(name="zipcode")
	private int zipcode;
	
	@Column(name="message")
	private String message;
	
	@Column(name="applyBy")
    private String applyBy;
	
	@Column(name="status")
    private String status;
	
	public Apply(String title, String address,int bedrooms, int bathrooms,int livingrooms, int accommodate, int zipcode, String applyBy,String status)
	{
		this.title=title;
		this.address=address;
		this.bathrooms=bathrooms;
		this.bedrooms=bedrooms;
		this.livingrooms=livingrooms;
		this.accommodate=accommodate;
		this.zipcode=zipcode;
		this.applyBy=applyBy;
		this.status=status;
	}
	
	public Apply()
	{}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public int getApplyID() {
		return applyID;
	}


	public void setApplyID(int applyID) {
		this.applyID = applyID;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getBedrooms() {
		return bedrooms;
	}


	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}


	public int getBathrooms() {
		return bathrooms;
	}


	public void setBathrooms(int bathrooms) {
		this.bathrooms = bathrooms;
	}


	public int getLivingrooms() {
		return livingrooms;
	}


	public void setLivingrooms(int livingrooms) {
		this.livingrooms = livingrooms;
	}


	public int getAccommodate() {
		return accommodate;
	}


	public void setAccommodate(int accommodate) {
		this.accommodate = accommodate;
	}


	public int getZipcode() {
		return zipcode;
	}


	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getApplyBy() {
		return applyBy;
	}

	public void setApplyBy(String applyBy) {
		this.applyBy = applyBy;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	

}
