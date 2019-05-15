package com.csuft.buyhouse.controller;

import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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
	@Autowired
	RedisTemplate redisTemplate;

	@GetMapping("/login")
	public String index() {
		return "login.html";
	}

	@PostMapping("/loginforpassword.json")
	@ResponseBody
	public JsonResult loginforpassword(@RequestBody User user,HttpServletRequest request) {
		System.out.println(user);
		userService.loginforPassword(user,request);
		return JsonResult.success();
	}
	
	@PostMapping("/loginforcode.json")
	@ResponseBody
	public JsonResult loginforcode(@RequestBody User user,HttpServletRequest request) {
		System.out.println(user);
		userService.loginforCode(user,request);
		return JsonResult.success();
	}

	@PostMapping("/register.json")
	@ResponseBody
	public JsonResult<Integer> register(@RequestBody User user) {
		userService.save(user);
		return JsonResult.success(user.getId());
	}
	
	//找回密码
	@PostMapping("/getback.json")
	@ResponseBody
	public JsonResult<Integer> getback(@RequestBody User user) {

		int code=userService.updatepassword(user);
		return JsonResult.success(code);
	}

	@PostMapping("/getcode.json")
	@ResponseBody
	public JsonResult getcode(@RequestBody User user) {
		System.out.println(user);
		Integer code = 1234;
	//	Integer code=CodeUtil.code(user.getUserPhone());

		redisTemplate.opsForValue().set(user.getUserPhone(), code.toString(), 60, TimeUnit.SECONDS);
		System.out.println(redisTemplate.opsForValue().get(user.getUserPhone()));
		return JsonResult.success();
	}

}
