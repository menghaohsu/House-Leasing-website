package com.paul.spring.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.paul.spring.exception.AdException;
import com.paul.spring.pojo.Email;
import com.paul.spring.pojo.User;



public class UserDAO extends DAO {

	public UserDAO() {
    }

    public User get(String username)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from User where name = :username");
            q.setString("username", username);
            User user = (User) q.uniqueResult();
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + username, e);
        }
    }

    public User create(String username, String password,String emailId, String firstName, String lastName)
            throws AdException {
        try {
            begin();
            System.out.println("hihihi");
            Email email = new Email(emailId);
            User user = new User(username, password);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            email.setUser(user);
            getSession().save(user);
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e); 
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }

    public void delete(User user)
            throws AdException {
        try {
            begin();
            getSession().delete(user);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete user " + user.getName(), e);
        }
    }
    public User logIn(String name, String password)throws AdException{
    	try {
    		begin();
			Query q = getSession().createQuery("from User where name = :name and password = :password");
			q.setString("name", name);
			q.setString("password", password);
			User user = (User)q.uniqueResult();
			commit();
			return user;
    	}catch(HibernateException e){
    		rollback();
            throw new AdException("Could not find the user", e);
    	}
    }
    
    public boolean isAdmin(String username, String password){
    	if(username.equals("admin")&& password.equals("admin")){
    		return true;
    	}else{
    		return false;
    	}
    }
}
