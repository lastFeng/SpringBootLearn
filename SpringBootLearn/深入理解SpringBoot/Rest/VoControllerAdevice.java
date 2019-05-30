package com.springboot.rest.exception;

@ControllerAdvice(
	basePackages = {"com.springboot.rest.controller.usercontroller.*"},
	annotations = {Controller.class, RestController.class})
public class VoControllerAdevice{
	// �쳣�������Զ����쳣���ͽ������ش���
	@ExceptionHandler(value=NotFoundException.class)
	// ��JSON��﷽ʽ��Ӧ
	@ResponseBody
	// ����Ϊ����������״̬��
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String, Object> exception(HttpServletRequest request, NotFoundException ex){
		Map<String, Object> msgMap = new HashMap<>();
		// ��ȡ�쳣��Ϣ
		msgMap.put("code", ex.getCode);
		msgMap.put("message", ex.getCustomMsg());
		return msgMap;
	}
}