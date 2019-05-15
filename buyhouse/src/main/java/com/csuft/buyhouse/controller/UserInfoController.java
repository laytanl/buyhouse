package com.csuft.buyhouse.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csuft.buyhouse.Service.UserInfoService;
import com.csuft.buyhouse.entity.HouseInfo;
import com.csuft.buyhouse.entity.UserInfo;
import com.csuft.buyhouse.util.JsonResult;

@Controller
public class UserInfoController {
	@Autowired
	UserInfoService userInfoService;
	
	@PostMapping("/collection.json")
	@ResponseBody
	public JsonResult<Integer> add(@RequestBody UserInfo userInfo) {
		userInfoService.save(userInfo);
		return JsonResult.success(userInfo.getId());
	}
	@PostMapping("/cancel.json")
	@ResponseBody
	public JsonResult<Integer> delete(@RequestBody UserInfo userInfo) {
		userInfoService.delete(userInfo);
		return JsonResult.success(userInfo.getId());
	}
	
	@PostMapping("/getdata.json")
	@ResponseBody
	public JsonResult<List<HouseInfo>> getdata(@RequestBody UserInfo userInfo) {
		List<HouseInfo> houseInfos=userInfoService.getdata(userInfo);
		return JsonResult.success(houseInfos);
	}
}
