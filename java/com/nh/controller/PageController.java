package com.nh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
//	跳转到content.html
	@GetMapping("/content")
	public String content() {
		return "content";
	}

//	跳转到management.html
	@GetMapping("/grbolg/manage")
	public String manage() {
		return "management";
	}
	
//	登录界面
	@GetMapping("/userLogin")
	public String login() {
		return "grbolglogin";
	}
	
//	403错误页面
	@GetMapping("/forbidden")
	public String forbidden() {
		return"forbidden";
	}

}
