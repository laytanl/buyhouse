package com.csuft.buyhouse.Service;

import java.util.List;

import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csuft.buyhouse.Dao.HouseInfoDao;
import com.csuft.buyhouse.Dao.UserInfoDao;
import com.csuft.buyhouse.entity.HouseInfo;
import com.csuft.buyhouse.entity.User;
import com.csuft.buyhouse.entity.UserInfo;
import com.csuft.buyhouse.util.PlatformException;

@Service
public class HouseInfoService {

	@Autowired
	HouseInfoDao houseInfoDao;
	@Autowired
	UserInfoDao userInfoDao;
	@Autowired
	SQLManager sqlManager;

	public void add(HouseInfo houseInfo) {
		houseInfoDao.insertTemplate(houseInfo, true);
	}

	public List<HouseInfo> queryByCondtion(HouseInfo houseInfo) {
		List<HouseInfo> houseInfos = houseInfoDao.queryByCondtion(houseInfo);
		return houseInfos;
	}

	public HouseInfo queryById(UserInfo userInfo) {
		HouseInfo houseInfo1 = houseInfoDao.unique(userInfo.getHouseInfoId());
		UserInfo query = new UserInfo();
		if (userInfo.getUserPhone() != null) {
			query.setUserPhone(userInfo.getUserPhone());
			query.setHouseInfoId(userInfo.getHouseInfoId());
			UserInfo dbuser = userInfoDao.templateOne(query);
			if (dbuser == null) {
				houseInfo1.setCollec(0);
			} else {
				houseInfo1.setCollec(1);
			}
		}
		else{
			houseInfo1.setCollec(0);
		}

		return houseInfo1;
	}

}
