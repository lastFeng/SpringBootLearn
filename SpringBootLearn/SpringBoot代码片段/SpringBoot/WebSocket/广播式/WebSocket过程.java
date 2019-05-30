// Websocket�㲥ʽ�����������Ϣʱ���Ὣ��Ϣ���͸����������˵�ǰendpoint�������
/**
	�������£�
		1. ����WebSocket����Ҫ����������ʹ��@EnableWebSocketMessageBroker,������WebSocket֧��
			���̳�AbstractWebSocketMessageBrokerConfig�࣬��д�䷽��������WebSoket
		
		// ʹ��STOMPЭ����������ڴ���message broker������Ϣ������������֧��@MessageMapping
		@EnableWebSocketMessageBroker
		@Configuration
		public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{
		
		// ע��STOMPЭ��Ľڵ㣨endpoint������ӳ���ָ��URL
			@Override
			public void registerStompEndpoints(StompEndpointRegistry registry){
				// ע��endpoint�����ƶ�ʹ��SockJSЭ��
				registry.addEndpoint("/endpointWisely").withSockJS();
			}
			
			// ������Ϣ����Message broker��
			@Override
			public void configureMessageBroker(MessageBrokerRegistry registry){
				// �㲥ʽ����һ��/topic��Ϣ����
				registry.enableSimpleBroker("/topic");
			}
		}
**/

/**
		2. ����������˷��͵���Ϣ�ô������
		public class BroadcastFromClientMessage{
			private String name;
			public String getName(){
				return name;
			}
		}
*/

/**
		3. ���������������͵Ĵ�����Ϣ
		public class BroadcastFromServerMessage{
			private String respoonseMessage;
			public BroadcastFromServerMessage(String responseMessage){
				this.responseMessage = responseMessage;
			}
			
			public String getResponseMessage(){
				return this.responseMessage;
			}
		}
*/

/***
		4. ��ʾ������
		@RestController
		pulbic class WsController{
			@MessageMapping("/welcome")   // ӳ���ַ
			@SendTo("/topic/getResponse")	// �����˸�·���µ������������Ϣ
			public BroadcastFromServerMessage say(BroadcastFromClientMessage message) throws Exception{
				Thread.sleep(1000);
				return new BroadcastFromServerMessage("Welcome" + message.getName() + "!");
			}
			
		}
***/