package com.paul.spring.dao;

import java.util.List;

import org.hibernate.HibernateException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import com.paul.spring.exception.AdException;
import com.paul.spring.pojo.HouseAdvert;
import com.paul.spring.pojo.User;

public class AdvertDAO extends DAO {

    public HouseAdvert create(String title, String address,int bedrooms, int bathrooms,int livingrooms,int accommodate, long category_id,String categoryName,int zipcode)
            throws AdException {
        try {
            begin();
            HouseAdvert advert = new HouseAdvert(title,address,bedrooms,bathrooms,livingrooms,accommodate,category_id,categoryName,zipcode);
            getSession().save(advert);
            commit();
            return advert;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create advert", e);
            throw new AdException("Exception while creating advert: " + e.getMessage());
        }
    }

    public void delete(HouseAdvert advert)
            throws AdException {
        try {
            begin();
            getSession().delete(advert);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete advert", e);
        }
    }
    public List searchByZipcode(int zipcode) throws AdException
    {
    	 try {
    		 begin();
             Query q = getSession().createQuery("from HouseAdvert where zipcode = :zipcode");
             q.setInteger("zipcode", zipcode);
             List list = q.list();
             commit();
             return list;
         } catch (HibernateException e) {
             rollback();
             throw new AdException("Could not find House", e);
         }
    }
    public List searchByCategory(String category) throws AdException
    {
    	 try {
    		 begin();
             Query q = getSession().createQuery("from HouseAdvert where categoryid = :categoryid");
             q.setString("categoryid", category);
             List list = q.list();
             commit();
             return list;
         } catch (HibernateException e) {
             rollback();
             throw new AdException("Could not find House", e);
         }
    }
    public List search() throws AdException
    {
    	 try {
    		 begin();
             Query q = getSession().createQuery("from HouseAdvert");
             List list = q.list();
             commit();
             return list;
         } catch (HibernateException e) {
             rollback();
             throw new AdException("Could not find Houser", e);
         }
    }
}