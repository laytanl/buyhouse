package com.csuft.buyhouse.Dao;

import java.util.List;

import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;

import com.csuft.buyhouse.entity.NewhouseInfo;

@SqlResource("admin.newhouseInfo")
public interface NewHouseInfoDao extends BaseMapper<NewhouseInfo>{

	List<NewhouseInfo> queryByCondtion(NewhouseInfo NewHouseInfo);

	List<NewhouseInfo> queryByinfos();


}
