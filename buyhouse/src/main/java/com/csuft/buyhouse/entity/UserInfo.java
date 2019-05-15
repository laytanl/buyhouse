package com.csuft.buyhouse.entity;

import org.beetl.sql.core.TailBean;

public class UserInfo extends TailBean{
	private Integer id;
	private String userPhone;
	private Integer houseInfoId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public Integer getHouseInfoId() {
		return houseInfoId;
	}
	public void setHouseInfoId(Integer houseInfoId) {
		this.houseInfoId = houseInfoId;
	}
	
	
}
