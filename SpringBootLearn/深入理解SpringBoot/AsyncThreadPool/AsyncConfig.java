package com.sprigboot.async.config;

@Configuration
// ����ע�⣬�Ϳ���ʹ��@Async����Springʹ���첽
@EnableAsync
public class AsyncConfig implements AsyncConfigurer{
	// �����̳߳�
	@Override
	public  Executor getAsyncExecutor(){
		// �����̳߳�
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		
		// �����߳�����
		taskExecutor.setCorePoolSize(10);
		taskExecutor.setMaxPoolSize(30);
		taskExecutor.setQueueCapacity(2000);
		
		// �̳߳س�ʼ��
		taskExecutor.initialize();
		return taskExecutor;
	}
}