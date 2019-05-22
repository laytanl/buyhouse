package com.csuft.buyhouse.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csuft.buyhouse.Dao.ManagerDao;
import com.csuft.buyhouse.entity.Manager;
import com.csuft.buyhouse.util.PlatformException;

@Service
public class ManagerService {
	@Autowired
	ManagerDao managerDao;

	public void loginforPassword(Manager Manager) {
		Manager query = new Manager();
		query.setUsername(Manager.getUsername());
		query.setPassword(Manager.getPassword());
		Manager dbManager = managerDao.templateOne(query);
		if (dbManager == null) {
			throw new PlatformException("用户名或密码错误");
		} 
	}
	
}
