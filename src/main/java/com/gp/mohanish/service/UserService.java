package com.gp.mohanish.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.mohanish.dao.IUserDao;
import com.gp.mohanish.model.User;

/**
 * @author mohanish
 *
 */

@Service("iUserService")
public class UserService implements IUserService {
		
	@Autowired
	IUserDao iUserDao;
	
	public User getUser(String [] userObj){
		return iUserDao.getUser(userObj);
	}
	
}
