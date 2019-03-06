package com.csuft.buyhouse.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csuft.buyhouse.Dao.UserDao;
import com.csuft.buyhouse.entity.User;
import com.csuft.buyhouse.util.PlatformException;

@Service
public class UserService{
	@Autowired
	UserDao userDao;
	
	public void save(User user) {
//		User query=new User();
//		query.setUserPhone(user.getUserPhone());
//		query.setUserPassword(user.getUserPassword());
		try {
			userDao.insertTemplate(user,true);
		} catch (Exception e) {
			new PlatformException("注册失败");
		}
		
	}
	
}