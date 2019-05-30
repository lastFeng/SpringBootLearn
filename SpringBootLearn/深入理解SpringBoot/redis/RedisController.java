package com.springboot.redis.controller;

@Controller
@RequestMapping("/redis")
public class RedisController{
	@Autowired
	private RedisTemplate redisTemplate = null;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate = null;
	
	@RequestMapping("/stringAndHash")
	@ResponseBody
	public Map<String, Object> testStringAndHash(){
		redisTemplate.opsForValue.set("key1", "value1");
		
		// ע������ʹ����JDK�����л���������Redis����ʱ������������������
		redisTemplate.opsForValue.set("int_key", "1");
		stringRedisTemplate.opsForValue.set("int", "1");
		// ʹ������
		stringRedisTemplate.opsForValue.increment("int", "1");
		
		// ��ȡ�ײ�Jedis����
		Jedis jedis = (Jedis)redisTemplate.getConnectionFactory().getConnection().getNativeConnection();
		
		jedis.decr("int");
		
		Map<String, String> hash = new HashMap<>();
		hash.put("field1", "value1");
		hash.put("field2", "value2");
		
		// ����һ��ɢ����������
		stringRedisTemplate.opsForHash().putAll("hash", hash);
		
		// ����һ���ֶ�
		stringRedisTemplate.opsForHash().put("hash", "field3", "value3");
		
		// ��ɢ�в�����key����Ҳ����������ͬһ��ɢ���������ͽ��в���
		BoundHashOperations hashOps = stringRedisTemplate.boundHashOps("hash");
		
		// ɾ�������ֶ�
		hashOps.delete("field1", "field2");
		
	  // ����һ���ֶ�
	  hashOps.put("field4", "value4");
	  
	  Map<String, Object> map = new HashMap<>();
	  map.put("success", true);
	  return map;
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> testList(){
		
		// ����߽�����Ԫ��
		stringRedisTemplate.opsForList().leftPushAll("list1", "1", "2");
		stringRedisTemplate.opsForList().rightPushAll("list2", "1", "2");
		
		BoundListOperations listOps = stringRedisTemplate.boundListOps("list1");
		
		Long size = listOps.size();
		
		List elements = listOps.range(0, size-2);
		
		Map<String, Object> map = new HashMap<>();
		map.put("success", true);
		return map;
	}
}