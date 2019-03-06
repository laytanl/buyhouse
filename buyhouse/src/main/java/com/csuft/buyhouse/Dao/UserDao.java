package com.csuft.buyhouse.Dao;

import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;


import com.csuft.buyhouse.entity.User;

@SqlResource("admin.user")
public interface UserDao extends BaseMapper<User>{
	
}