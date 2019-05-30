package com.springboot.springmvc.converter.validator.custom;

/***omit imports***/

public class UserValidator implements Validator{
	// ��֤��ֻ֧��User����֤
	@Override
	public boolean support(Class<?> clazz){
		return clazz.equals(User.class);
	}
	
	@Override
	public void validate(Object target, Errors errors){
		// ����Ϊ��
		if(target == null){
			// ֱ���ڲ��������������Ͳ��ܽ���������ķ���
			errors.rejectValue("", null, "�û�����Ϊ��");
			return ;
		}
		
		// ǿ��ת��
		User user = (User)target;
		// �û����ǿմ�
		if(StringUtils.isEmpty(user.getUserName())){
			// ���Ӵ��󣬿��Խ������������
			errors.rejectValue("userName", null, "�û�����Ϊ��");
		}
	}
}