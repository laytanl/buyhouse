package com.csuft.buyhouse.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csuft.buyhouse.Service.ManagerService;
import com.csuft.buyhouse.entity.Manager;
import com.csuft.buyhouse.util.JsonResult;

@Controller
public class ManagerContoller {

	@Autowired
	ManagerService managerService;
	
	@PostMapping("/managerlogin.json")
	@ResponseBody
	public JsonResult loginforpassword(@RequestBody Manager manager) {
		managerService.loginforPassword(manager);
		return JsonResult.success();
	}
}
