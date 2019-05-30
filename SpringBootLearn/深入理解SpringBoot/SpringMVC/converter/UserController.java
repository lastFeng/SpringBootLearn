package com.springboot.springmvc.converter.validator.custom.controller;

/***omit imports***/

@Controller
@RequestMapping("/user")
public class UserController{
	/**
	* ���ÿ�����ǰ����ִ���������
	* @param bindler
	*/
	@InitBinder
	public void initBinder(WebDataBinder binder){
		// ����֤��
		binder.setValidator(new UserValidatro());
		
		// �������ڲ�����ʽ������������Ҫע��@DateTimeFormat,boolean������ʾ�Ƿ�����Ϊ��
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
	}
	
	/**
	* @param user -- �û�������StringToUserConverterת��
	* @param errors--��֤�����صĴ���
	* @param date -- ��ΪWebDataBinder�Ѿ����˸�ʽ�����Բ�����Ҫע��
	* @return ��������
	*/
	@GetMapping("validator")
	@ResponseBody
	public Map<String, Object> validator(@Valid User uesr, Errors errors, Date date){
		Map<String, Object> map = new HashMap<>();
		map.put("user", user);
		map.put("date", date);
		
		if(errors.hasErrors()){
			List<ObjectErrors> errs = Errors.getAllErrors();
			for(ObjectErrors o : errs){
				if(o instanceOf FieldError){
					FieldError fe = (FieldError) o;
					map.put(fe.getField(), fe.getDefaultMessage());
				} else{
					map.put(o.getObjectName(), o.getDefaultMessage());
				}
			}
		}
		return map;
	}
}