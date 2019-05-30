package com.springboot.redis.publish.controller;

/***omit imports***/

@RestController
public class RedisPublishController{
	@Autowired
	private RedisTemplate redisTemplate;
	
	@GetMapping("/testPublish", produces="application/json;charset=utf-8")
	public Map<String,Object> testPublish(String topicName, Object message){
		/**
		* ʹ��RedisTemplate��converAndSend(channel, message)����
		* channel��������������
		* message������������Ϣ
		**/
		Topic topic = new ChannelTopic(topicName);
		
		redisTemplate.convertAndSend(topic, message);
		
		Map<String, Object> map = new HashMap<>();
		map.put("success", true);
		return map;
	}
}