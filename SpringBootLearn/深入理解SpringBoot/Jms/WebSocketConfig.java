package com.springboot.stomp.config

@EnableWebSocketMessageBroker
@Configuration
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
	// ע��������˵�
	@override
	public void registerStompEndpoints(StompEndpointRegistry registry){
		// ����һ���������˵�
		registry.addEndpoint("/socket").withSockJS();
		registry.addEndpoint("/wsuser").withSockJS();
	}
	
	// ����������˵�����Ͷ���ǰ׺
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry){
		// �ͻ��˶���·��ǰ׺
		registry.enableSimpleBroker("/sub", "/queue");
		// ����˵�����ǰ׺
		registry.setApplicationDestinationPrefixes("/request");
	}
}