package com.springboot.springmvc.converter.pojo;

/***omit imports***/

/**
* ����JSR-303��֤
* ʹ��ע�������֤
**/
public class ValidatorPojo{
	// �ǿ��ж�
	@NotNull(message="id����Ϊ��")
	private Long id;
	
	// ֻ���ǽ���������---��ȥ�����ã�@Past
	@Future(message="��Ҫһ����������")
	// ����ת����ʽ
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull
	private Date date;
	
	// ��Сֵ�����ֵ
	@NotNull
	@DecimalMin(value="0.1")
	@DecimalMax(value="10000.00")
	private Double doubleValue;
	
	// �޶���Χ
	@Range(min=1, max=888, message="��ΧΪ1��888")
	pirvate Long range;
	
	// ������֤
	@Email(message="�����ʽ����")
	private String mail;
	
	// �ַ�����������
	@Size(min=20, max=30, message="�ַ�������Ҫ��20��30֮��)
	private String size;
	
	/***setter and getter***/
}