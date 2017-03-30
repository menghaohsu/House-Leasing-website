package com.paul.spring.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.paul.spring.pojo.HouseCategory;
import com.paul.spring.exception.AdException;

public class CategoryDAO extends DAO {

    public HouseCategory get(String title) throws AdException {
        try {
            begin();
            Query q=getSession().createQuery("from HouseCategory where title= :title");
            q.setString("title",title);
            HouseCategory category=(HouseCategory)q.uniqueResult();
            commit();
            return category;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not obtain the named category " + title + " " + e.getMessage());
        }
    }

    public List list() throws AdException {
        try {
        	System.out.println("1");
            begin();
            Query q = getSession().createQuery("from HouseCategory");
            List list = q.list();
            System.out.println("2");
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the categories", e);
        }
    }

    public HouseCategory create(String title) throws AdException {
        try {
            begin();
            HouseCategory cat = new HouseCategory(title);
            getSession().save(cat);
            commit();
            return null;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create the category", e);
            throw new AdException("Exception while creating category: " + e.getMessage());
        }
    }

    public void save(HouseCategory category) throws AdException {
        try {
            begin();
            getSession().update(category);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not save the category", e);
        }
    }

    public void delete(HouseCategory category) throws AdException {
        try {
            begin();
            getSession().delete(category);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete the category", e);
        }
    }
}