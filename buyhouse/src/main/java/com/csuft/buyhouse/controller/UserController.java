package com.csuft.buyhouse.controller;

import java.util.concurrent.TimeUnit;

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
	public JsonResult loginforpassword(@RequestBody User user) {
		System.out.println(user);
		userService.loginforPassword(user);
		return JsonResult.success();
	}
	
	@PostMapping("/loginforcode.json")
	@ResponseBody
	public JsonResult loginforcode(@RequestBody User user) {
		System.out.println(user);
		userService.loginforCode(user);
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
		System.out.println(user);
		Integer code = 1234;
//		Integer code=CodeUtil.code(user.getUserPhone());
//		u.setUserCode(code.toString());
//		u.setUserPhone(user.getUserPhone());
		redisTemplate.opsForValue().set(user.getUserPhone(), code.toString(), 60, TimeUnit.SECONDS);
		System.out.println(redisTemplate.opsForValue().get(user.getUserPhone()));
		return JsonResult.success();
	}

}
