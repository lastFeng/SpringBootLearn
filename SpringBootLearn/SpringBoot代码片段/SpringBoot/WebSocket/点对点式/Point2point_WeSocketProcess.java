// ��Ե�WebSocket���ܹ������Ϣ��˭���ͣ���˭���յ�����
// ������ spring-boot-starter-security

/**
	1. Spring Security������
**/
@Configuration
@EnableSpringSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
				.authorizeRequests()
				.antMatchers("/", "/login").permitAll()			// ����·����/���͡�/login��������
				.anyRequest().authenticated()
				.and()
				.formLogin()																// ��¼����
				.loginPage("/login")												// �ɹ���¼��ת/chat
				.defaultSuccessUrl("/chat")
				.permitAll()
				.and()
				.logout()																		// �˳�������
				.permitAll();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth
				.inMemoryAuthentication()
				.withUser("wyf").password('wyf').roles("USER")						// �����û�����ΪROLE_USER���µ��û�
				.and()
				.withUser("wisely").password("wisely").roles("USER");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/resources/static/**");
	}
}

/***
	2. WebSocket����
*/
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry){
		registry.addEndpoint("/endpointWisely").withSockJS();
		regsitry.addEndpoint("/endpointChat").withSockJS();
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry){
		registry.enableSimpleBroker("/queue", "/topic");
	}
}

/**
	3. ������
*/
@Controller
public class WSController{
	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	
	@MessageMapping("/chat")
	public void handleChat(Principal principal, String msg){
		if(principal.getName().equals("wyf")){
			messagingTemplate.convertAndSendToUser("wisely", "/queue/notifications", principal.getName()+"-send:"+msg)''
		} else{
			messagingTemplate.convertAndSendToUser("wyf", "/queue/notifications", principal.getName()+"-send:"+msg);
		}
	}
}

/**
	4. ����ҳ���ViewController
*/
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{
	@Override
	public void addViewControllers(ViewControllerRegistry registry){
		registry.addViiewController("/ws").setViewName("/ws");
		registry.addViiewController("/login").setViewName("/login");
		registry.addViiewController("/chat").setViewName("/chat");
	}
}