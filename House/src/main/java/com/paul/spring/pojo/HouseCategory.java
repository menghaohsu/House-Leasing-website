package com.paul.spring.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.paul.spring.pojo.HouseAdvert;



@Entity
@Table(name="categorytable")
public class HouseCategory {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="categoryid", unique = true, nullable = false)
    private long id;
	
	@Column(name="title")
    private String title;
    
	@OneToMany(fetch=FetchType.LAZY, mappedBy="category")
	private Set<HouseAdvert> adverts = new HashSet<HouseAdvert>();

    public HouseCategory(String title) {
        this.title = title;
        this.adverts = new HashSet<HouseAdvert>();
    }

    HouseCategory() {
    }

    public Set<HouseAdvert> getAdverts() {
        return adverts;
    }

    void setAdverts(Set<HouseAdvert> adverts) {
        this.adverts = adverts;
    }

    public void addAdvert(HouseAdvert advert) {
        getAdverts().add(advert);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}