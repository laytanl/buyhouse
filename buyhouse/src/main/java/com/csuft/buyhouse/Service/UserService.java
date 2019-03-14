package com.csuft.buyhouse.Service;

import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.csuft.buyhouse.Dao.UserDao;
import com.csuft.buyhouse.entity.User;
import com.csuft.buyhouse.util.JsonResult;
import com.csuft.buyhouse.util.PlatformException;

@Service
public class UserService {
	@Autowired
	UserDao userDao;
	@Autowired
	SQLManager sqlManager;

	@Autowired
	RedisTemplate redisTemplate;

	// 验证码登录
	public void loginforCode(User user) {
		if (!user.getUserCode().equals(redisTemplate.opsForValue().get(user.getUserPhone()))) {
			throw new PlatformException("验证码错误");
		}

	}

	public void loginforPassword(User user) {
		User query = new User();
		query.setUserPassword(user.getUserPassword());
		query.setUserPhone(user.getUserPhone());
		User dbuser = userDao.templateOne(query);
		System.out.println(dbuser);
		if (dbuser == null) {
			throw new PlatformException("用户名或密码错误");
		}
	}

	// 更新密码
	public int updatepassword(User user) {
		if (user.getUserCode().equals(redisTemplate.opsForValue().get(user.getUserPhone()))) {
			User query = new User();
			query.setUserPhone(user.getUserPhone());
			User dbuser = userDao.templateOne(query);
			if (dbuser == null) {
				throw new PlatformException("用户名不存在,请先注册");
			}
			User recode = new User();
			recode.setUserPassword(user.getUserPassword());
			Query<User> query1 = sqlManager.query(User.class);
			int count = query1.andEq("user_phone", user.getUserPhone()).update(recode);
			return count;
		}
		else {
			throw new PlatformException("验证码错误");
		}
	}

	public void save(User user) {
		if (user.getUserCode().equals(redisTemplate.opsForValue().get(user.getUserPhone()))) {
			User query = new User();
			query.setUserPhone(user.getUserPhone());
			User dbuser = userDao.templateOne(query);
			if (dbuser != null) {
				throw new PlatformException("用户名已经存在，注册失败");
			}
			try {
				userDao.insertTemplate(user, true);
			} catch (Exception e) {
				new PlatformException("注册失败");
			}
		} else {
			throw new PlatformException("验证码错误");
		}

	}

}