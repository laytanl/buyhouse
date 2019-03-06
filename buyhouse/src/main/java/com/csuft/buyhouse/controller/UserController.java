package com.csuft.buyhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csuft.buyhouse.Service.UserService;
import com.csuft.buyhouse.entity.User;
import com.csuft.buyhouse.util.JsonResult;


@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	@ResponseBody
	public JsonResult register(@RequestBody User user) {
		System.out.println(user);
		userService.save(user);
		return JsonResult.success();
	}
	
//	@PostMapping("/getcode")
//	@ResponseBody
//	public String getcode(@RequestBody User u) {
//		phone=u.getPhone();
//		m=code();
//		return "ok";
//	}
}
