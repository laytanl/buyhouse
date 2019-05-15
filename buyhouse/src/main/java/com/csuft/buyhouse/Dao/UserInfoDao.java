package com.csuft.buyhouse.Dao;

import java.util.List;

import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;

import com.csuft.buyhouse.entity.UserInfo;

@SqlResource("admin.userinfo")
public interface UserInfoDao  extends BaseMapper<UserInfo>{

	List<UserInfo> queryhouseInfoId(UserInfo userInfo);


}
