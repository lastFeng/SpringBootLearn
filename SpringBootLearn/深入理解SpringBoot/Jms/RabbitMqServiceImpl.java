package com.springboot.rabbitmq.queue.service.impl;

public class RabbitMqServiceImpl implements ConfirmCallback, RabbitMqService{
	@Value("${rabbitmq.queue.msg}")
	private String msgRouting = null;
	
	@Value("${rabbitmq.queue.user}")
	private String userRouting = null;
	
	// ע����SpringBoot�Զ����õ�RabbitTemplate
	@Autowired
	private RabbitTemplate rabbitTemplate = null;
	
	// ������Ϣ
	@Override
	public void sendMsg(String msg){
		System.out.println("������Ϣ��"+ msg + "��");
		rabbitTemplate.setConfirmCallback(this);
		rabbitTemplate.convertAndSend(msgRouting, msg);
	}
	
	@Override
	public void sendUser(User user){
		System.out.println("������Ϣ��" + user + "��");
		rabbitTemplate.setConfirmCallback(this);
		rabbitTemplate.convertAndSend(userRouting, user);
	}
	
	// �ص�ȷ�Ϸ���
	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause){
		if(ack){
			System.out.println("��Ϣ���ͳɹ�");
		}else{
			System.out.println("��Ϣ����ʧ��" + cause);
		}
	}
}