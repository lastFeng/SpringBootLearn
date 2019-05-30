package com.springboot.rabbitmq.queue.receiver;

@Component
public class RabbitMessageReceiver{
	// ��������ַ���������
	@RabbitListener(queue={"${rabbitmq.queue.msg}"})
	public void receiveMsg(String msg){
		System.out.println("�յ���Ϣ����" + msg + "��");
	}
	
	@RabbitListener(queue={"${rabbitmq.queue.user}"})
	public void receiveUser(User user){
		System.out.println("�յ���Ϣ����" + user + "��");
	}
}