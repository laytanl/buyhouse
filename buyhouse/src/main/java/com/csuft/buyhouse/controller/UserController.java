package com.csuft.buyhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	User u=new User();
	
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
		System.out.println(u);
//		if(user.getUserCode().equals(u.getUserCode())&&user.getUserPhone().equals(u.getUserPhone()))
//		{
//			userService.save(user);
//			return JsonResult.success(user.getId());
//		}
//		else {
//			return JsonResult.failMessage("验证码错误");
//		}
		userService.save(user);
		return JsonResult.failMessage("验证码错误");
		
	}
	
	@PostMapping("/getcode.json")
	@ResponseBody
	public JsonResult getcode(@RequestBody User user) {
		int code=CodeUtil.code(user.getUserPhone());
		u.setUserCode(code);
		u.setUserPhone(user.getUserPhone());
		try {
			Thread.sleep(60000);
			u.setUserCode(null);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return JsonResult.success();
	}
	
}
