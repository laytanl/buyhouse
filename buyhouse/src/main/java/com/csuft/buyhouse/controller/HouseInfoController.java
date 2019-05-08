package com.csuft.buyhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csuft.buyhouse.Service.HouseInfoService;
import com.csuft.buyhouse.entity.HouseInfo;
import com.csuft.buyhouse.util.JsonResult;

@Controller
public class HouseInfoController {

	@Autowired
	HouseInfoService houseInfoService;
	
	@GetMapping("/sell")
	public String index() {
		return "sell.html";
	}
	//用户提交
	@PostMapping("/add.json")
	@ResponseBody
	public JsonResult add(@RequestBody HouseInfo houseInfo) {
		System.out.println(houseInfo);
		houseInfoService.add(houseInfo);
		return JsonResult.success();
	}
}
