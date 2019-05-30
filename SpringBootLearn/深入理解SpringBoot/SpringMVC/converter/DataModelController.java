package com.springboot.springmvc.model.controller;

/***omit imports***/

@Controller
@RequestMapping("/data")
public class DataModelController{
	// ע���û�������
	@Autowired
	private UserService userService;
	
	// ����model���
	@GetMapping("/model")
	public String userModel(Long id, Model model){
		User user = userService.getUserById(id);
		model.setAttribute("user", user);
		
		// ���ﷵ���ַ�������SpingMvc�У����Զ�����ModelAndView�Ұ�����
		return "data/user";
	}
	
	// ����ModelMap
	@GetMapping("/modelMap")
	public ModelAndView useModelMap(Long id, ModelMap modelMap){
		User user = userService.getUserById(id);
		ModelAndVies mv = new ModelAndView();
		
		mv.setViewName("data/user");
		
		modelMap.put("user", user);
		// ����Ҫ��ModelMap�ֶ����õ�ModelAndView�У����Զ�����
		return mv;
	}
	
	// ����ModelAndView
	@GetMapping("/mav")
	public ModelAndView useModeAndView(Long id, ModelAndView mv){
		User user = userService.getUserById(id);
		mv.addObject("user", user);
		
		return mv;
	}
}