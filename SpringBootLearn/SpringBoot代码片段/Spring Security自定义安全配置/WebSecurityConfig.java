// ͨ����ʾ���õķ�ʽ���Զ��尲ȫ����

// ͨ����չ��WebSecurityConfigurerAdapter
@Configuration
@EnableWebSecurity
public WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private ReaderRpository readerRpository;
	
	// �������url��Ȩ��
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
				.authorizeRequests()
				.antMatchers("/").access("hasRole('READER')")
				.antMatchers("/**").permitAll()
				
				.and()
				
				.formLogin()
				.loginPage("/login")
				.failureUrl("/login?error=true");
	}
	
	// �����ɫ�û�
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth
				.userDetailsService(new UserDetailsService(){
					@Override
					public UserDetails loadUserByUserName(String userName) throws UsernameNotFountException{
						return readerRepository.findOne(userName);
					}
				});
	}
}