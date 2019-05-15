package com.csuft.buyhouse.Dao;

import java.util.List;

import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;

import com.csuft.buyhouse.entity.HouseInfo;

@SqlResource("admin.houseinfo")
public interface HouseInfoDao extends BaseMapper<HouseInfo>{

	List<HouseInfo> queryByCondtion(HouseInfo houseInfo);


}
