// Springͨ������ִ������TaskExecutor����ʵ�ֶ��̺߳Ͳ������

// ������
// 1. ʹ��ThreadPoolTaskExecutorʵ�ֻ����̳߳ص�TaskExecutor
// 2. ����@EnableAsync�������첽����֧�֣��ڷ�����ʹ��@Asyncע���������첽����


// �����첽����֧��
// ͨ��ʵ�ֽӿ������һ�������̳߳ص�TaskExecutor
@Configuration
@EnableAsync
public class TaskExecutorConfig implements AsyncConfigurer{
	@Override
	public Executor getAsyncExecutor(){
		THreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(5);			// ���ú��ĳش�С
		taskExecutor.setMaxPoolSize(10);			// �������ش�С
		taskExecutor.setQueueCapacity(25);		// ���ö�������
		taskExecutor.initialize();						// ��ʼ���̳߳�
		
		return taskExecutor;
	}
	
	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler(){
		return null;
	}
}

// ����ִ����
class AsyncTaskService{
	@Async
	public void executeAsyncTask(Integer i){
		System.out.println("ִ���첽����" + i);
	}
	
	@Async
	public void executeAsyncTaskPlus(Integer i){
		System.out.println("ִ���첽����" + (i+1));
	}
}