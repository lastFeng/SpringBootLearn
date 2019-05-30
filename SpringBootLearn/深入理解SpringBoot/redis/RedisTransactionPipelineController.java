package com.springboot.redis.transaction;

/***omit imports***/

@Controller
/***ʹ��Redis��ˮ�߽���������������redis����***/ 
public class RedisTransactionPipelineController{
	@Autowired
	private RedisTemplate redisTemplate = null;
	
	@RequestMapping("/pipeline")
	@ResponseBody
	public Map<String, Object> testPipeline(){
	
		// 	
		Long start = System.currentTimeMillis();
		
		List list = (List) redisTemplate.executePipeline(RedisOperations operations -> {
			for(int i = 1; i <= 100000; i++){
				operations.opsForValue().set("pipeline_" + i, "value_" + i);
				String value = operation.opsForValue().get("pipeline_" + i);
				if(i == 100000){
					System.out.println("����ֻ�ǽ����˶��У�û������ִ�У�����ֵΪ��" + value + " ������Ԥ���value_" + i);
				}
			}
			return null;
		});
		
		Long end = System.currentTimeMillis();
		
		System.out.println("��ʱ��" + (end - start) + "ms");
		
		Map<String, Object> map = new HashMap<>();
		map.put("success", true);
		return map;
	}
}