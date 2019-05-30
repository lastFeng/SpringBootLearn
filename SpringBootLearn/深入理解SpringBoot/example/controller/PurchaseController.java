package com.springboot.example.controller;

/***������***/
@RestController
@RequestMapping("/example")
public class PurchaseController{
	@Autowired
	private PurchaseService purchaseService;
	
	// ����JSP��ͼ
	@GetMapping("/test")
	public ModelAndView testPage(){
		ModelAndView mv = new ModelAndView("test");
		return mv;
	}
	
	@PostMapping("/purchase")
	public Result purchase(Long userId, Long productId, Integer quantity){
		boolean success = purchaseService.purchase(userId, productId, quantity);
		String message = success ? "�����ɹ�" : "����ʧ�ܣ���治��";
		Result result = new Resutl(success, message);
		return result;
	}
	
	
	
	class Result{
		private boolean success;
		private String message;
		
		public Result(){
		}
		
		public Result(boolean success, String message){
			this.success = success;
			this.message = message;
		}
		/***setter and getter***/ 
	}
}