package com.springboot.security.inmemoryauthentication;

/***omit imports***/
@SpringBootApplication(scanBasePackages="com.springboot.security")
public class SecurityApplication extends WebSecurityConfigureAdapter {
	// ��д�������������û�ǩ������
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		// ���������
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		// ʹ���ڴ�洢
		auth.inMemoryAuthentication()
				// �������������
				.passwordEncoder(passwordEncoder)
				// ע���û�admin������Ϊabc��������USER��ADMIN�Ľ�ɫȨ��
				.withUser("admin")
				// ͨ��passwordEncoder.encode("abc")�õ����ܺ������
				.password("...")
				.roles("USER", "ADMIN")
			.and()
				// ע���û�myuser������Ϊ123456��������USER�Ľ�ɫȨ��
				.withUser("myuser")
				.password("...")
				.roles("USER");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		// ���������
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> userConfig = 
					auth.inMemoryAuthentication()
							.passwordEncoder(passwordEncoder);
							
		// ע���û�
		userConfig.withUser("admin")
							.password("...")
							.authorities("ROLE_USER", "ROLE_ADMIN");
							
		// ע���û�
				userConfig.withUser("myuser")
							.password("...")
							.authorities("ROLE_USER");
	}
}