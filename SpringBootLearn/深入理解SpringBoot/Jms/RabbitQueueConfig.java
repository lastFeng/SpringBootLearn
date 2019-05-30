package com.springboot.rabbitmq.queue.config;

// ��������RabbitMQ����
@Configuration
public class RabbitQueueConfig{
	@Value("${rabbitmq.queue.msg}")
	private String msgQueueName;
	
	@Value("${rabbitmq.queue.user}")
	private String userQueueName;
	
	@Bean
	public Queue createQueueMsg(){
		// �����ַ�����Ϣ���У�booleanֵ�����Ƿ�־û���Ϣ
		return new Queue(msgQueueName, true);
	}
	
	@Bean
	public Queue createQueueUser(){
		// �����û���Ϣ���У�booleanֵ�����Ƿ�־û���Ϣ
		return new Queue(msgQueueName, true);
	}
}