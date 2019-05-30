package com.springboot.redis.cache.custom.config;

/***omit imports***/
@Configuration
public class CustomRedisCacheConfig{
	@Autowired
	private RedisConnectionFactory redisConnectionFactory;
	
	// �Զ���Redis���������
	@Bean("redisCacheManager")
	public RedisCacheManager redisCacheManager(){
		// Redis������д����
		RedisCacheWriter writer = RedisCacheWriter.lockingRedisCacheWriter(connectionFactory);
		
		// ����Redis�����Ĭ������
		RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
		
		// ����JDK���л���
		config = config.serializeValuesWith(
							SerializationPair.fromSerializer(new JdkSerializationRedisSerializer()));
		
		// ����ǰ׺
		config = config.disableKeyPrefix();
		
		// ����10min��ʱ
		config = config.entryTtl(Duration.ofMinutes(10));
		
		// ����Redis���������
		RedisCacheManager redisCacheManager = new RedisCacheManager(writer, config);
		
		return redisCacheManager;
	}
}