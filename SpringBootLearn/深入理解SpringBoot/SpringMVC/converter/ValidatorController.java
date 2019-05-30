package com.springboot.springmvc.converter.controller;

/***omit imports***/

@Controller
public class ValidatorController{
	@GetMapping("/valid/page")
	public String validPage(){
		return "/validato/pojo";
	}
	
	/**
	* ������֤��������
	* @param vp ��Ҫ��֤��POJO��ʹ��ע��@Valid��ʾ��֤
	* @param errors ������Ϣ����spring mvcͨ����֤pojo���Զ����
	* @return ������ϢMap
	*/
	@RequestMapping(value="/valid/validate")
	@ResponseBody
	public Map<String, Object> Validate(@Valid @RequestBody ValidatorPojo vp, Errors errors){
		Map<String, Object> errMap = new HashMap<>();
		// ��ȡ�����б�
		List<ObjectError> objErr = errors.getAllErrors();
		
		for(ObjectError err: objErr){
			String key = null;
			String msg = null;
			
			// �ֶδ���
			if(err instanceOf FieldError){
				FieldError fe = (FieldError) err;
				key = fe.getField()
			}
			// ���ֶδ���
			else{
				key = err.getObjectName();
			}
			msg = err.getDefaultMessage();
			errMap.put(key, msg);
		}
		return errMap;
	}
}