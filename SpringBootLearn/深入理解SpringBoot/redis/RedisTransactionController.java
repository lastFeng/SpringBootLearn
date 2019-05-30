package com.springboot.redis.transaction;

/***omit imports***/

/***������Ҫע�⣺RedisTemplate�ļ���ɢ�нṹ��fieldʹ���ַ������л�����StringRedisSerializer��***/
public class RedisTransactionController{
	@Autowired
	RedisTemplate redisTemplate = null;
	
	@RequestMapping("/multi")
	@ResponseBody
	public Map<String, Object> testMulti(){
		redisTemplate.opsForValue().set("key1", "value1");
		
		// ͨ����������ǣ� watch...multi...exec...
		// ���У�
		//   watch�����Redis�ļ�
		//   multi����ʼ���񣬵���������ִ�У���������һ��������
		//   exec�� ���Redis�ļ�ֵ���Ƿ����˸ı䣬Ҫôȫ��ִ�У�Ҫôȫ��ȡ��
		
		// ����Lambda���ʽ��������
		List list = (List) redisTemplate.execute((RedisOperations operations) -> {
						// ������Ҫ��ص�key1
						operations.watch("key1");
						
						// ����������exec����ִ��ǰ��ȫ����ֻ�ǽ������
						operations.multi();
						operations.opsForValue().set("key2", "value2");
						
						// operations.opsForValue().increment("key1", 1);
						
						// ��ȡֵ��Ϊnull����Ϊredisֻ�ǰ������������У�����ִ���������û���κη���ֵ���������׳���
						// Ҳ���������value2��ֵӦ����Ϊnull�������ǡ�value2��
						Object value2 = operatios.opsForValue().get("key2");						
						System.out.println("�����ڶ��У�����value��ֵΪ�� " + value2 + " ������Ԥ���е�value2��");
						
						operations.opsForValue().set("key3", "value3");
						System.out.println("�����ڶ��У�����value��ֵΪ��" + value3 + " ������Ԥ���е�value3��");
						
						// ִ��exec��������ж�key1�Ƿ��ڼ�غ��޸Ĺ�������ǣ���ִ�����񣻷����ִ������
						return operations.exec();
				});
				
		System.out.println(list);
		Map<String, Object> map = new HashMap<>();
		map.put("success", true);
		return map;
	}
}