package com.csuft.buyhouse.entity;

import org.beetl.sql.core.TailBean;

public class UserNewinfo  extends TailBean{
	private Integer id;
	private String userPhone;
	private Integer newhouseInfoId;
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
	public Integer getNewhouseInfoId() {
		return newhouseInfoId;
	}
	public void setNewhouseInfoId(Integer newhouseInfoId) {
		this.newhouseInfoId = newhouseInfoId;
	}
	
}
