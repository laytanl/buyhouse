package com.csuft.buyhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csuft.buyhouse.Service.UserService;
import com.csuft.buyhouse.entity.User;
import com.csuft.buyhouse.util.CodeUtil;
import com.csuft.buyhouse.util.JsonResult;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/login")
	public String index() {
		return "login.html";
	}
	
	
	@PostMapping("/login.json")
	@ResponseBody
	public JsonResult login(@RequestBody User user) {
		System.out.println(user);
		userService.save(user);
		return JsonResult.success();
	}
	

	@PostMapping("/register.json")
	@ResponseBody
	public JsonResult<Integer> register(@RequestBody User user) {
		userService.save(user);
		return JsonResult.success(user.getId());
	}
	
	@PostMapping("/getcode.json")
	@ResponseBody
	public JsonResult getcode(@RequestBody User user) {
		int code=CodeUtil.code();
		user.setUserCode(code);
		return JsonResult.success();
	}
	
}
