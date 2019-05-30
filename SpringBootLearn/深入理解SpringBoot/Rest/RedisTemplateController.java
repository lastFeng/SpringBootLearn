package com.springboot.redis.controller.redistemplate;

public class RedisTemplateController{
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user/{id}")
	public static UserVo getUser(Long id){
		// ����url
		String url = "http://localhost:8080/user/{id}";
		// ͨ��RedisTemplate����ȡ����һ������Ϊurl���ڶ�������Ϊ���������ͣ�����������ΪURI·��������������ҪURL�е��Զ��崫��Ĳ�����
		UserVo userVo = redisTempleate.getForObject(url, UserVo.class, id);
		
		System.out.println(userVo.getUserName());
		return userVo;
	}
	
	public static List<UserVo> findUser(String userName, String note, int start, int limit){
		Map<String, Object> params = new HashMap<>();
		params.put("note", note)
		params.put("userName", userName);
		params.put("start", start);
		params.put("limit", limit);
		String url = "http://localhost:8080/users/{userName}/{note}/{start}/{limit}";
		ResponseEntiy<List> responseEntity = restTemplate.getForEntity(url, List.class, params);
		List<UserVo> userVoes = responseEntity.getBody();
		return userVoes;
	}
	
	public static User insertUser(UserVo newUserVo){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		HttpEntity<UserVo> request = new HttpEntity<>(newUserVo, headers);
		User user = redisTemplate.postForObject("http://localhost:8080/user", request, User.class);
		
		System.out.println(user.getId());
		
		return user;
	}
	
	// ִ��DELETE����
	public static void deleteUser(Long id){
		restTemplate.delelte("http://localhost:8080/user/{id}", id);
	}
	
	// ��ȡ��������Ӧͷ���Ժ�HTTP״̬��
	public User insertUserEntity(UserVo userVo){
		// ����ͷ
		HttpHeaders headers = new HttpHeaders();
		// ����ͷ����
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		// �������������ͷ
		HttpEntity<UserVo> request = new HttpEntity<>(userVo, headers);
		
		// url
		String url = "http://localhost:8080/user/entity";
		
		// ���������
		ResposeEntity<User> response = restTemplate.postForEntity(url, request, User.class);
		
		// ��ȡ��Ӧ��
		User user = response.getBody();
		
		// ��ȡ��Ӧͷ
		HttpHeaders respHeader = response.getHeaders();
		// ��ȡ��Ӧ����
		List<String> success = respHeader.get("success");
		
		// ��ӦHTTP״̬��
		int status = response.getStatusCodeValue();
		System.out.println(user.getId());
		return user;
	}
	
	// RedisTemplate��exchange()��������Ϊ��Դ�Ľ���,����Խϸ�
	public static User useExchange(UserVo userVo, Long id){
		// ����ͷ
		HttpHeaders header = new HttpHeaders();
		// ��������
		header.setContent(MediaType.APPLICATION_JSON_UTF8);
		// ������ͷ������
		HttpEntity<UserVo> request = new HttpEntity<>(userVo, header);
		String url = "http://localhost:8080/user/entity"
		// ���������
		ResponseEntity<User> response = redisTemplate.exchange(url, HttpMethod.POST, request, User.class);
		// ��ȡ��Ӧͷ
		HttpHeaders respHeader = response.getHeaders();
		// ��ȡ��Ӧ��
		User user = response.getBody();
		// ��Ӧͷ����
		List<String> success = respHeader.get("success");
		// ��Ӧ��HTTP״̬��
		int status = response.getStatusCodeValue();
		// �޸�URL��Դ
		url = "http://localhost:8080/user/{id}";
		
		ResponseEntity<UserVo> userVoEntity = restTemplate.exchange(url, HttpMethod.GET, null, UserVo.class, id);
		// ��ȡ��Ӧ��
		UserVo userVoe = userVoEntity.getBody();
		
		System.out.println(userVoe.getUserName());
		
		return user;
	}
}