package com.springboot.async.service.impl;

@Service
public class AsyncServiceImpl implements AsyncService{
	@Override
	@Async
	public void generateReport(){
		// ��ӡ�첽�߳�����
		System.out.println("�����߳����ƣ�" + "��" + Thread.currentThread().getName() + "��");
	}
}