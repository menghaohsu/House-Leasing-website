package com.paul.spring.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="adverttable")
public class HouseAdvert {
	
	@Id @GeneratedValue
	@Column(name="advertid", unique = true, nullable = false)
	private long id;
	
	@Column(name="title")
	private String title;
	
	@Transient //will stored in advert table
	private String postBy;
	
	@Column(name="message")
	private String message;
	
	@Column(name="address")
	private String address;
	
	@Column(name="bedrooms")
	public int bedrooms;
	
	@Column(name="bathrooms")
	public int bathrooms;
	
	@Column(name="livingrooms")
	public int livingrooms;
	
	@Column(name="accommodate")
	public int accommodate;
	
	@Column(name="zipcode")
	public int zipcode;
	
	//keep one and comment other and vice-versa to explain the result in console
    @ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    //@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="user")
	private User user;
	
	@Transient //will stored in advert table
	private String category_name;
	
	@JoinColumn(name="categoryid")
	private long category;
	
	public HouseAdvert(String title,String address,int bedrooms,int bathrooms,int livingrooms, int accommodate, long category_id,String categoryName,int zipcode) {
        this.title = title;
        this.address = address;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.livingrooms = livingrooms;
        this.accommodate = accommodate;
        this.category = category_id;
        this.category_name=categoryName;
        this.zipcode=zipcode;
    }
	
	HouseAdvert() {
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPostBy() {
		return postBy;
	}

	public void setPostBy(String postBy) {
		this.postBy = postBy;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
	
	public int getAccommodate() {
		return accommodate;
	}

	public void setAccommodate(int accommodate) {
		this.accommodate = accommodate;
	}

	public int getLivingrooms() {
		return livingrooms;
	}

	public void setLivingrooms(int livingrooms) {
		this.livingrooms = livingrooms;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public long getCategory() {
		return category;
	}

	public void setCategory(long category) {
		this.category = category;
	}
	
	public String getAddress(){
		return address;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

}
