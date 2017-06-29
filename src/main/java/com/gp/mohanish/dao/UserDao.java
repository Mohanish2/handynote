/**
 * 
 */
package com.gp.mohanish.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gp.mohanish.model.User;

/**
 * @author mohanish
 *
 */
@Repository("iUserDao")
@Transactional
public class UserDao implements IUserDao {

	@Autowired 
	private SessionFactory sessionFactory;
	
	public User getUser(String [] userObj){
		Session session;

		try {
		    session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
		    session = sessionFactory.openSession();
		}
		
		String email = userObj[0];
		String password = userObj[1];
		String hql = "from User u where u.email = :email and u.password = :password";
		List<User> userList = session.createQuery(hql).setString("email",email).setString("password", password).list();
		
		if(userList != null && userList.size() > 0){
			return userList.get(0);			
		}else{
			return null;
		}
			
	}

}
