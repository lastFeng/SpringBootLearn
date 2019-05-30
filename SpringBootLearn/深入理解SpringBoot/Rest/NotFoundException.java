package com.springboot.redis.exception;

/*** �������ʧ�ܵ��쳣 ***/
public class NotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	// �쳣����
	private Long code;
	// �쳣�Զ�����Ϣ
	private String customMsg;
	
	public NotFoundException(){
	}
	
	public NotFoundException(Long code, String customMsg){
		super();
		this.code = code;
		this.customMsg = customMsg;
	}
	
	/*** setter and getter ***/ 
}