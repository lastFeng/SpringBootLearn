package com.springboot.security.configure;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	// ����ӳ���ϵ
	@Override
	public void addViewControllers(ViewControllerRegistry registry){
		// ʹ��/login/pageӳ��Ϊlogin.jsp
		registry.addViewController("/login/page").setViewName("login");
		// ʹ��/logout/pageӳ��Ϊlogout_welcome.jsp
		registry.addViewController("/logout/page").setViewName("logout_welcome");
		// ʹ��/logout ӳ��Ϊlogout.jsp
		registry.addViewController("/logout").setViewName("logout");
	}
}