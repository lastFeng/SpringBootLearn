package com.springboot.springmvc.interceptor.controller;

@Controller
@RequestMapping("/intercepor")
public class CustomInterceptorController{
	@GetMapping("/start")
	public String start(){
		System.out.println("ִ�д������߼�");
		return "/welcome";
	}
}