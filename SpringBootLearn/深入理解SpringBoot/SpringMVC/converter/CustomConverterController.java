package com.springboot.springmvc.converter.controller;

/***omit imports***/

@Controller
@RequestMapping("/converter")
public class CustomConverterController{
	
	@GetMapping("/")
	@ResponseBody
	public User getUserByConverter(User user){
		return user;
	}
	
	// ͨ��HTTP����ʹ�ö��š�,���ָ���������ֵ
	// ͨ�����λ�ȡ���ݣ�����convert
	@GetMapping("/list")
	@ResponseBody
	public List<User> list(List<User> userList){
		return userList;
	}
}