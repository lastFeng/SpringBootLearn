package com.springboot.async.controller;

@Controller
@RequestMapping("/async")
public class AsyncController{
	@Autowired
	private AsyncService asyncService;
	
	@GetMapping("/page")
	public String asyncPage(){
		System.out.println("�����߳����ƣ�" + "��" + Thread.currentThread().getName() + "��");
		// �����첽����
		asyncService.generateReport();
		return "async";
	}
}