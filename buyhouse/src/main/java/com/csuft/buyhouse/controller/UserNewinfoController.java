package com.csuft.buyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.csuft.buyhouse.Service.UserNewinfoService;
import com.csuft.buyhouse.entity.HouseInfo;
import com.csuft.buyhouse.entity.NewhouseInfo;
import com.csuft.buyhouse.entity.UserInfo;
import com.csuft.buyhouse.entity.UserNewinfo;
import com.csuft.buyhouse.util.JsonResult;

@Controller
public class UserNewinfoController {

	@Autowired
	UserNewinfoService userNewinfoService;
	
	@PostMapping("/collectionNewHouse.json")
	@ResponseBody
	public JsonResult<Integer> add(@RequestBody UserNewinfo userInfo) {
		userNewinfoService.save(userInfo);
		return JsonResult.success(userInfo.getId());
	}
	@PostMapping("/cancelNewHouse.json")
	@ResponseBody
	public JsonResult<Integer> delete(@RequestBody UserNewinfo userInfo) {
		userNewinfoService.delete(userInfo);
		return JsonResult.success(userInfo.getId());
	}
	
	@PostMapping("/getnewHousedata.json")
	@ResponseBody
	public JsonResult<List<NewhouseInfo>> getdata(@RequestBody UserNewinfo userInfo) {
		List<NewhouseInfo> houseInfos=userNewinfoService.getdata(userInfo);
		return JsonResult.success(houseInfos);
	}


}
