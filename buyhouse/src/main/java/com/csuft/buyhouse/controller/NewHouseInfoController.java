package com.csuft.buyhouse.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseBody;

import com.csuft.buyhouse.Service.NewHouseInfoService;
import com.csuft.buyhouse.entity.HouseInfo;
import com.csuft.buyhouse.entity.NewhouseInfo;
import com.csuft.buyhouse.entity.UserInfo;
import com.csuft.buyhouse.entity.UserNewinfo;
import com.csuft.buyhouse.util.JsonResult;

@Controller
public class NewHouseInfoController {
	@Autowired
	NewHouseInfoService newHouseInfoService;
	
	private List<String> srcs = new ArrayList<>();

	
	@PostMapping("/listnewhouseById.json")
	@ResponseBody
	public JsonResult<NewhouseInfo> listById(@RequestBody UserNewinfo UserNewinfo) {

		NewhouseInfo houseinfos = newHouseInfoService.queryById(UserNewinfo);
		return JsonResult.success(houseinfos);
	}

	

	@PostMapping("/listnewHouse.json")
	@ResponseBody
	public JsonResult<List<NewhouseInfo>> list(@RequestBody NewhouseInfo newhouseInfo) {

		List<NewhouseInfo> newhouseinfos = newHouseInfoService.queryByCondtion(newhouseInfo);
		return JsonResult.success(newhouseinfos);
	}
	

}
