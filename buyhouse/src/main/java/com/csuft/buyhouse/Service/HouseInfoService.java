package com.csuft.buyhouse.Service;

import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csuft.buyhouse.Dao.HouseInfoDao;
import com.csuft.buyhouse.entity.HouseInfo;

@Service
public class HouseInfoService {

	@Autowired
	HouseInfoDao houseInfoDao;
	@Autowired
	SQLManager sqlManager;
	
	public void add(HouseInfo houseInfo) {
		houseInfoDao.insertTemplate(houseInfo);
		
	}
	
	
}
