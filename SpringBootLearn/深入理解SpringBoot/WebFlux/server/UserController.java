package com.springboot.webflux.controller;

@RestController
public class UserController{
	@Autowired
	private UserService userService;
	
	// ��ȡ�û�
	@GetMapping("/user/{id}")
	public Mono<UserVo> getUser(@PathVariable Long id){
		return userService.getUser(id)
											.map(u --> translate(u));
	}
	
	// �����û�
	@PostMapping("/user")
	public Mono<UserVo> insertUser(@RequestBody User user){
		return userService.insertUser(user).map(u -> translate(u));
	}
	
	// �����û�
	@PutMapping("/user")
	public Mono<UserVo> updataUser(@RequestBody User user){
		return userService.updateUser(user).map(u->translate(u));
	}
	
	// ɾ���û�
	@DeleteMapping("/user/{id}")
	public Mono<Void> deleteUser(@PathVariable Long id){
		return userService.deleteUser(id);
	}
	
	// ��ѯ�û�
	@GetMapping("/user/{userName}/{note}")
	public Flux<UserVo> findUsers(@PathVariable String userName, @PathVariable String note){
		return userService.findUsers(userName, note).map(u -> translate(u));
	}
	
	/**
	* ���PO��VO��ת��
	* @param user    po�־ò����
	* @return UserVo vo��ͼ����
	*/ 
	private UserVo translate(User user){
		UserVo vo = new UserVo();
		vo.setId(user.getId());
		vo.setUserName(user.getUserName());
		vo.setSexCode(user.getSex().getCode());
		vo.setSexName(user.getSex().getName());
		vo.setNote(user.getNote());
		return vo;
	}
}