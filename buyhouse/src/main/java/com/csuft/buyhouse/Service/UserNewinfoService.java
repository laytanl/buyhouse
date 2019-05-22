package com.csuft.buyhouse.Service;


import java.util.ArrayList;
import java.util.List;

import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csuft.buyhouse.Dao.NewHouseInfoDao;
import com.csuft.buyhouse.Dao.UserNewinfoDao;
import com.csuft.buyhouse.entity.HouseInfo;
import com.csuft.buyhouse.entity.NewhouseInfo;
import com.csuft.buyhouse.entity.UserInfo;
import com.csuft.buyhouse.entity.UserNewinfo;
import com.csuft.buyhouse.util.PlatformException;

@Service
public class UserNewinfoService {

	@Autowired
	UserNewinfoDao userNewinfoDao;

	@Autowired
	NewHouseInfoDao houseInfoDao;
	@Autowired
	SQLManager sqlManager;

	public void save(UserNewinfo user) {
		if (user.getUserPhone() != null) {
			userNewinfoDao.insertTemplate(user, true);
		}
		else {
			throw new PlatformException("请先登录");
		}
	}

	public void delete(UserNewinfo UserNewinfo) {
		Query<UserNewinfo> query1 = sqlManager.query(UserNewinfo.class);
		int count = query1.andEq("user_phone", UserNewinfo.getUserPhone())
				.andEq("newhouse_info_id", UserNewinfo.getNewhouseInfoId()).delete();

	}

	public List<NewhouseInfo> getdata(UserNewinfo userInfo) {
		List<NewhouseInfo> houseInfos = new ArrayList<>();
		List<UserNewinfo> userInfos = userNewinfoDao.querynewhouseInfoId(userInfo);
		for (UserNewinfo userInfo1 : userInfos) {
			NewhouseInfo houseInfo = houseInfoDao.unique(userInfo1.getNewhouseInfoId());
			houseInfos.add(houseInfo);
		}
		return houseInfos;
	
		
	}

}
