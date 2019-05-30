package com.springboot.security.configure.spring;

public class SpringSecurityConfigure extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequest()
				// ʹ��Spring���ʽ�޶�ֻ�н�ɫROLE_USER����ROLE_ADMIN���Է���
				.antMatchers("/user/**").access("hasRole('USER') or hasRole('ADMIN')")
				// ���÷���Ȩ�޸�ROLE_ADMIN��Ҫ����������¼���Ǽ�ס�ҵ�¼��
				.antMatchers("/admin/welcome").access("hasAuthority('ROLE_ADMIN') && isFullAuthenticated()")
				// ����"/admin/welcome2"����Ȩ�޸���ɫROLE_ADMIN����������ȫ��¼
				.antMatchers("/admin/welcome2").access("hasAuthority('ROLE_ADMIN')")
				.and().remeberMe()
				.and().formLogin()
				.and().httpBasic();
	}
}