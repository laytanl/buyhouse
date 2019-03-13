package com.csuft.buyhouse.entity;

import org.beetl.sql.core.TailBean;

public class User extends TailBean{
	private Integer id;
	private String userPhone;
	private String userPassword;
	private String userCode;
	
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
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	@Override
	public String toString() {
		return "User [userPhone=" + userPhone + ", userPassword=" + userPassword + ", userCode=" + userCode + "]";
	}
	
	
	

	
	
	


}
