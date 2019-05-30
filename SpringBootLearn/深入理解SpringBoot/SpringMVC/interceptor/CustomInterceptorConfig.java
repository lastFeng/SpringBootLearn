package com.springboot.springmvc.interceptor.config

/*** omit imports ***/

/**
* ͨ����дWebMvcConfig��addInterceptors������ע���Զ���������
*/

@Configuration
public class CustomInterceptorConfig{
	@Override
	public void addInterceptors(InterceptorRegistry registry){
		InterceptorRegistration iR = registry.addInterceptor(new CustomSimpleInterceptor());
		
		// ����������ʽ����������Ӧ·���µ����أ�ֻ���ء�/interceptor/���µ�����
		iR.addPathPatterns("/interceptor/*")
	}
}