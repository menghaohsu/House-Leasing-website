package com.paul.spring.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.paul.spring.exception.AdException;
import com.paul.spring.pojo.Apply;


public class ApplyDAO extends DAO {
	
	public Apply get(int id)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from User where id = :id");
            q.setInteger("id", id);
            Apply a = (Apply) q.uniqueResult();
            commit();
            return a;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + id, e);
        }
    }
	
	public Apply create(String title, String address,int bedrooms, int bathrooms,int livingrooms, int accommodate, int zipcode, String applyBy, String status)
			throws AdException{
		
		try {
            begin();

            status="Waiting";
            Apply apply = new Apply(title, address, bedrooms,bathrooms, livingrooms,accommodate,zipcode,applyBy,status);
            //apply.setStatus("Waiting");
            getSession().save(apply);
            commit();
            return apply;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while creatinghouse: " + e.getMessage());
        }
	}
	public Apply approve(Apply apply)
			throws AdException{
		
		try {
            begin();
            apply.setStatus("Approve");
            getSession().save(apply);
            commit();
            return apply;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while creatinghouse: " + e.getMessage());
        }
	}
	public Apply disaprove(Apply apply)
			throws AdException{
		
		try {
            begin();
            apply.setStatus("Disapprove");
            getSession().save(apply);
            commit();
            return apply;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while creatinghouse: " + e.getMessage());
        }
	}
	
	public List showAll()throws AdException{
		try{
			begin();
			Query q = getSession().createQuery("from Apply where status=:status");
			q.setString("status", "Waiting");
			List l = q.list();
			commit();
			return l;
		}catch (HibernateException e) {
            rollback();
            throw new AdException("Couldn't find: " + e.getMessage());
        }
	}
	
	public Apply search(String title, String applyBy)throws AdException{
		try{
			begin();
			Query q = getSession().createQuery("from Apply where title=:title and applyBy=:applyBy");
			q.setString("title", title);
			q.setString("applyBy", applyBy);
			Apply apply=(Apply)q.uniqueResult();
			commit();
			return apply;
		}catch (HibernateException e) {
            rollback();
            throw new AdException("Couldn't find: " + e.getMessage());
        }
	}
 
	public void delete(Apply apply)
            throws AdException {
        try {
            begin();
            getSession().delete(apply);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete house", e);
        }
    }
	
	public List check(String applyBy)throws AdException{
		try{
			begin();
			Query q = getSession().createQuery("from Apply where applyBy=:applyBy");
			q.setString("applyBy", applyBy);
			List l = q.list();
			commit();
			return l;
		}catch (HibernateException e) {
            rollback();
            throw new AdException("Couldn't find: " + e.getMessage());
        }
	}
	
	
}
