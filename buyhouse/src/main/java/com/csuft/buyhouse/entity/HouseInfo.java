package com.csuft.buyhouse.entity;

import java.util.ArrayList;
import java.util.List;

import org.beetl.sql.core.TailBean;

public class HouseInfo extends TailBean{
	private Integer id;
	private String name;
	private Integer room;
	private Integer hall;
	private Integer guard;
	private Integer size;
	private String tel;
	private String num;
	private String sellerName;
	private Integer price;
	private String urban;
	private String address;
	private String src;
	private String picture1;
	private String picture2;
	private String picture3;
	private int collec;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Integer getRoom() {
		return room;
	}
	public void setRoom(Integer room) {
		this.room = room;
	}
	public Integer getHall() {
		return hall;
	}
	public void setHall(Integer hall) {
		this.hall = hall;
	}
	
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public Integer getGuard() {
		return guard;
	}
	public void setGuard(Integer guard) {
		this.guard = guard;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public int getCollec() {
		return collec;
	}
	public void setCollec(int collec) {
		this.collec = collec;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getUrban() {
		return urban;
	}
	public void setUrban(String urban) {
		this.urban = urban;
	}
	public String getPicture1() {
		return picture1;
	}
	public void setPicture1(String picture1) {
		this.picture1 = picture1;
	}
	public String getPicture2() {
		return picture2;
	}
	public void setPicture2(String picture2) {
		this.picture2 = picture2;
	}
	public String getPicture3() {
		return picture3;
	}
	public void setPicture3(String picture3) {
		this.picture3 = picture3;
	}
	
	
	
}
