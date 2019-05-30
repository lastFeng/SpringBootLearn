package com.springboot.redis.publish.main;

/***omit imports***/

// ����Redis��������Ϣ
@SpringBootApplication(scanBasePackages="com.springboot.redis.publish")
@MapperScan(basePackages="com.springboot.redis.publish", annotationClass=Repository.class)
public class RedisPublishMain{
	@Autowired
	private RedisTemplate redisTemplate = null;
	
	// Redis���ӹ���
	@Autowired
	private RedisConnectionFactory redisConnectionFactory = null;
	
	// Redis ��Ϣ������
	@Autowired
	private RedisMessageListener redisMessageListener = null;
	
	// �����
	@Autowired
	private ThreadPoolTaskScheduler taskScheduler = null;
	
	/**
	* ��������أ������̵߳ȴ�����Redis����Ϣ
	* @return
	**/ 
	@Bean
	public ThreadPoolTaskScheduler initTaskScheduler(){
		if(taskScheduler != null){
			return taskScheduler;
		}
		
		taskScheduler = new ThreadPoolTaskScheduler();
		taskScheduler.setPoolSize(20);
		
		return taskScheduler;
	}
	
	/**
	* ����Redis��������
	* @return
	**/
	@Bean
	public RedisMessageListenerContainer initRedisContainer(){
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		
		// Redis���ӹ���
		container.setConnectionFactory(redisConnectionFactory);
		
		// �������������
		container.setTaskExecutor(initTaskScheduler());
		
		// �����������������Ϊtopic1
		Topic topic = new ChannelTopic("topic1");
		
		// ʹ�ü���������Redis��Ϣ
		container.addMessageListener(redisMessageListener, topic);
		
		return container;
	} 
}