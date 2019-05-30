package com.springboot.redis.publish.listener;

/***omit imports***/

/***������Ϣ�����������������������͹�������Ϣ***/
@Component
public class RedisMessageListener implements MessageListener{
	/**
	* �õ���������Ϣ�󣬽��д���ķ���
	* @param message Redis���͹�������Ϣ
	* @param pattern ��������
	**/
	@Override
	public void onMessage(Message message, byte[] pattern){
		// ��Ϣ��
		String body = new String(message.getBody());
		// ��������
		String topic = new String(pattern);
		
		System.out.println(body);
		System.out.println(topic);
	}
}