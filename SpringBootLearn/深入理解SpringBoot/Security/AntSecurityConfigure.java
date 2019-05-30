package com.springboot.security.configure.ant;

pubic class AntSecurityConfigure extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		// �޶�ǩ�����Ȩ��
		http
				// ��һ��
				.authorizeRequests()
				// �޶���/user/welcome���������ɫROLE_USER����ROLE_ADMIN
				.antMatchers("/user/welcome", "/user/details").hasAnyRole("USER","ADMIN")
				// �޶���/admin/������������Ȩ�޸����ɫROLE_ADMIN
				.antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
				// ����·������ǩ�������
				.anyRequests().permitAll()
				
				// �ڶ���
				// and�������Ӵ�
				// ��û������Ȩ�޵���������������������
				and().anonymous()
				
				// ������
				// ʹ��Spring SecurityĬ�ϵĵ�¼ҳ��
				.and().formLogin()
				// ����HTTP������֤
				.and().httpBasic();
	}
}