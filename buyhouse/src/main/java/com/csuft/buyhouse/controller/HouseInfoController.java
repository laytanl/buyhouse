package com.csuft.buyhouse.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.MultipartConfigElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.csuft.buyhouse.Service.HouseInfoService;
import com.csuft.buyhouse.entity.Application;
import com.csuft.buyhouse.entity.HouseInfo;
import com.csuft.buyhouse.entity.UserInfo;
import com.csuft.buyhouse.util.JsonResult;

@Controller
public class HouseInfoController {

	@Autowired
	HouseInfoService houseInfoService;

	@GetMapping("/sell")
	public String index() {
		return "sell.html";
	}
	@GetMapping("/upload1")
	public String upload() {
		return "upload.html";
	}
	
	private List<String> srcs=new ArrayList<>();

	// 用户提交
	@PostMapping("/add.json")
	@ResponseBody
	public JsonResult add(@RequestBody HouseInfo houseInfo) {
		System.out.println(houseInfo);	
		houseInfo.setSrc(srcs.get(0));
		houseInfo.setPicture1(srcs.get(1));
		houseInfo.setPicture2(srcs.get(2));
		houseInfo.setPicture3(srcs.get(3));
		houseInfoService.add(houseInfo);
		return JsonResult.success();
	}

	@PostMapping("/list.json")
	@ResponseBody
	public JsonResult<List<HouseInfo>> list(@RequestBody HouseInfo houseInfo) {

		List<HouseInfo> houseinfos = houseInfoService.queryByCondtion(houseInfo);
		return JsonResult.success(houseinfos);
	}
	
	@PostMapping("/listById.json")
	@ResponseBody
	public JsonResult<HouseInfo> listById(@RequestBody UserInfo userInfo) {

		HouseInfo houseinfos = houseInfoService.queryById(userInfo);
		return JsonResult.success(houseinfos);
	}

   private static final Logger logger = LoggerFactory.getLogger(Application.class);
    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation("e:/tmp");
        return factory.createMultipartConfig();
    }

	@RequestMapping(value = "/upload")
	@ResponseBody
	public String upload(@RequestParam("file") MultipartFile file, @RequestParam("name") String name) {
		logger.info("name: " + name);
		if (file.isEmpty()) {
			return "文件为空";
		}
		// 获取文件名
		String fileName = file.getOriginalFilename();
		logger.info("上传的文件名为:" + fileName);
		// 获取文件的后缀名
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		logger.info("上传的后缀名为:" + suffixName);
		// 文件上传路径
		String filePath = "C:/Users/ltan/git/buyhouse/buyhouse/src/main/resources/static/picture/";
		// 解决中文问题,liunx 下中文路径,图片显示问题
		// fileName = UUID.randomUUID() + suffixName;
		File dest = new File(filePath + fileName);
		// 检测是否存在目录
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
		try {
			file.transferTo(dest);
			String src="./picture/"+fileName;
			System.out.println(src);
			srcs.add(src);
			return "上传成功";
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "上传失败";
	}

}
