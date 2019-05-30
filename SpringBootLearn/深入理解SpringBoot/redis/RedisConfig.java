package com.springboot.redis.config

/***omit imports***/

public class RedisConfig{
	private RedisConnectionFactory connectionFactory = null;
	
	@Bean(name="RedisConnectionFactory")
	public RedisConnectionFactory initRedisConnectionFactory(){
		if(connectionFactory != null){
			return connectionFactory;
		}
		
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		
		// ��������
		poolConfig.setMaxIdle(30);
		
		// ���������
		poolConfig.setMaxTotal(50);
		
		// ��������
		poolConfig.setMaxWaitMillis(10000);
		
		// ����Jedis���ӹ���
		JedisConnectionFactory connectionFaction = new JedisConnectionFactory(poolConfig);
		
		// ��ȡ������Redis����
		RedisStandaloneConfiguration rsCfg = connectionFactory.getStandaloneConfiguration();
		
		// ������Ӧ����
		connectionFactory.setHostName("127.0.0.1");
		connectionFactory.setPort(6379);
		connectionFactory.setPassword("123456");
		
		this.connectionFactory = connectionFactory;
		return connectionFactory;
	}
}