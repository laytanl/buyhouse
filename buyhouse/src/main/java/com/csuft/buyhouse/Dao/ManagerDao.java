package com.csuft.buyhouse.Dao;

import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;

import com.csuft.buyhouse.entity.Manager;

@SqlResource("admin.Manager")
public interface ManagerDao extends BaseMapper<Manager>{

}
