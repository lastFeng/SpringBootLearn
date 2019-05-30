package com.springboot.webflux.routefunctions.config;

// ��̬����
import static org.springframework.http.MediaType.APPLICATION_STREAM_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
/***other imports omit***/

@Configuration
public class RouterConfig{
	// ע���û�������
	@Autowired
	private UserHandler userHandler;
	
	// ����ͷ�û���������
	private static final String HEADER_NAME = "header_user";
	// ����ͷ������������
	private static final String HEADER_VALUE = "header_password";
	
	// �û�·��
	@Bean
	pubic RouterFunctions<ServerResponse> userRouter(){
		RouterFunction<ServerResponse> router = 
				// ��Ӧ����URI�Ķ�Ӧ��ϵ
				route(
					// GET������·��
					GET("/router/user/{id}")
					// ��Ӧ���Ϊ������
					.and(accpet(APPLICATION_STREAM_JSON)), 
					// ���崦����
					userHandler::getUser)
					
					// ����һ��·��
				.andRoute(
					POST("/router/user")
					.and(accept(APPLICATION_STREAM_JSON)),
					userHanler::insertUser)
				
				.andRoute(
					GET("/router/{userName}/{note}")
					.and(accept(APPLICATION_STREAM_JSON)),
					userHandler::findUsers)
					
				.andRoute(
					PUT("/router/user")
					.and(accept(APPLICATION_STREAM_JSON)),
					userHandler::updateUser)
					
				.andRoute(
					DELETE("/router/user/{id}")
					.and(accept(APPLICATION_STREAM_JSON)),
					userHandler::deleteUser)
				.andRoute(
				PUT("/router/user/name")
				.and(accept(APPLICATION_STREAM_JSON)),
				userHandler::updateUserName);
		return router;
	}
	
	@Bean
	public RouterFunction<ServerResponse> securityRouter(){
		RouterFunction<ServerResponse> router = 
					route(
						GET("/security/user/{id}")
						.and(accept(APPLICATION_STREAM_JSON)),
						userHandler::getUser
					).filter((request, next) -> filterLogic(request, next));
		return router;
	}
	
	private Mono<ServerResponse> filterLogic(ServerRequest request, HandlerFunction<ServerResponse> next){
		// ȡ������ͷ
		String userName = request.headers().header(HEADER_NAME).get(0);
		String password = request.headers().header(HEADER_VALUE).get(0);
		
		// ��֤ͨ��������
		if(!StringUtils.isEmpty(userName) && !StringUtils.isEmpty(password) && !userName.equals(password)){
			return next.handle(request);
		}
		
		return ServerResponse.status(HttpStatus.UNAUTHORIZED).build();
	}
}