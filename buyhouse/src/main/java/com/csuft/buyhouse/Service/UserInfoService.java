package com.csuft.buyhouse.Service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csuft.buyhouse.Dao.HouseInfoDao;
import com.csuft.buyhouse.Dao.UserInfoDao;
import com.csuft.buyhouse.entity.HouseInfo;
import com.csuft.buyhouse.entity.User;
import com.csuft.buyhouse.entity.UserInfo;
import com.csuft.buyhouse.util.PlatformException;

@Service
public class UserInfoService {
	@Autowired
	UserInfoDao userInfoDao;

	@Autowired
	HouseInfoDao houseInfoDao;
	@Autowired
	SQLManager sqlManager;

	public void save(UserInfo user) {

		if (user.getUserPhone() != null) {
			userInfoDao.insertTemplate(user, true);
		}
		else {
			throw new PlatformException("请先登录");
		}
	}

	public List<HouseInfo> getdata(UserInfo userInfo) {
		List<HouseInfo> houseInfos = new ArrayList<>();
		List<UserInfo> userInfos = userInfoDao.queryhouseInfoId(userInfo);
		for (UserInfo userInfo1 : userInfos) {
			HouseInfo houseInfo = houseInfoDao.unique(userInfo1.getHouseInfoId());
			houseInfos.add(houseInfo);
		}
		return houseInfos;
	}

	public void delete(UserInfo userInfo) {
		Query<UserInfo> query1 = sqlManager.query(UserInfo.class);
		int count = query1.andEq("user_phone", userInfo.getUserPhone())
				.andEq("house_info_id", userInfo.getHouseInfoId()).delete();

	}
}
