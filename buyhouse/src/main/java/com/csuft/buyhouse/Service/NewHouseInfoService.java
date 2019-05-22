package com.csuft.buyhouse.Service;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csuft.buyhouse.Dao.NewHouseInfoDao;
import com.csuft.buyhouse.Dao.UserInfoDao;
import com.csuft.buyhouse.Dao.UserNewinfoDao;
import com.csuft.buyhouse.entity.HouseInfo;
import com.csuft.buyhouse.entity.NewhouseInfo;
import com.csuft.buyhouse.entity.UserInfo;
import com.csuft.buyhouse.entity.UserNewinfo;

@Service
public class NewHouseInfoService {

	@Autowired
	NewHouseInfoDao newhouseInfoDao;
	@Autowired
	UserNewinfoDao userNewinfoDao;
	@Autowired
	SQLManager sqlManager;

	public void add(NewhouseInfo NewhouseInfo) {
		newhouseInfoDao.insertTemplate(NewhouseInfo, true);
	}

	public List<NewhouseInfo> queryByCondtion(NewhouseInfo newhouseInfo) {
		List<NewhouseInfo> houseInfos = newhouseInfoDao.queryByCondtion(newhouseInfo);
		return houseInfos;
	}

	public NewhouseInfo queryById(UserNewinfo userNewinfo) {
		NewhouseInfo houseInfo1 = newhouseInfoDao.unique(userNewinfo.getNewhouseInfoId());
		UserNewinfo query = new UserNewinfo();
		if (userNewinfo.getUserPhone() != null) {
			query.setUserPhone(userNewinfo.getUserPhone());
			query.setNewhouseInfoId(userNewinfo.getNewhouseInfoId());
			UserNewinfo dbuser = userNewinfoDao.templateOne(query);
			if (dbuser == null) {
				houseInfo1.setCollec(0);
			} else {
				houseInfo1.setCollec(1);
			}
		} else {
			houseInfo1.setCollec(0);
		}

		return houseInfo1;
	}
}
