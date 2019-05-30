package com.springboot.rest.controller;

/***omit imports***/
@Controller
public class UserController{
	// �û�����ӿ�
	@Autowired
	private UserSerivce userService;
	
	// ӳ��JSP��ͼ
	@GetMapping("/restful")
	public String index(){
		return "restful";
	}
	
	// �����û�
	@PostMapping("/user")
	@ResponseBody
	pubilc User insertUser(@RequestBody UserVo userVo){
		User user = this.changeToPo(userVo);
		return userService.insertUser(user);
	}
	
	// ��ȡ�û�
	@GetMapping(value="/user/{id}")
	@ResponseBody
	public UserVo getUser(@PathVariable("id") Long id){
		User user = userService.getUserById(id);
		return changeToVo(user);
	}
	
	// ��ȡ�û��б�
	@GetMapping("/users/{userName}/{note}/{start}/{limit}")
	@ResponseBody
	public List<UserVo> findUsers(
		@PathVariable("userName") String userName,
		@PathVariable("note") String note,
		@PathVariable("start") int start,
		@PathVariable("limit") int limit){
		List<User> userList = userService.findUserListByNameAndNote(userName, note, start, limit);
		return this.changeToVoes(userList);
	}
	
	// �޸��û���Ϣ
	@PutMapping("/user/{id}")
	@ResponseBody
	public User updateUser(@PathVariable("id") Long id, @RequestBody UserVo userVo){
		User user = this.changeToPo(userVo);
		user.setId(id);
		userService.updateUser(user);
		return user;
	}
	
	// ɾ���û�
	@DeleteMapping("/user/{id}")
	@ResponseBody
	public ResultVo deleteUser(@PathVariable("id") Long id){
		int result = userService.deleteUserById(id);
		
		ResultVo resultVo = new ResultVo(result > 0, result > 0 ? "���³ɹ�": "�����û���"+id +"��ʧ�ܡ�")
		return resultVo;
	}
	
	// ת��VO��ΪPo
	private User changeToPo(UserVo userVo){
		User user = new User();
		user.setId(userVo.getId());
		user.setUserName(userVo.getUserName());
		user.setSex(SexNum.getSexEnumz(userVo.getSexCode()));
		uer.setNote(uservo.getNote());
		return user;
	}
	
	// ת��PO��ΪVO
	private UserVo changeToVo(User user){
		UserVo userVo = new UserVo();
		userVo.setId(user.getId());
		userVo.setUserName(user.getUserName());
		userVo.setSexCode(user.getSex().getId());
		userVo.setSexName(user.getSex().getSex());
		userVo.setNote(user.getNote());
		return userVo;
	}
	
	// ��PO�б�ת����VO�б�
	private List<UserVo> changeToVoList(List<User> poList){
		List<UserVo> voList = new ArrayList<>();
		for(User user: poList){
			UserVo userVo = changeToVo(user);
			voList.add(userVo);
		}
		return voList;
	}
	
	// ���VO
	public class ResultVo{
		private Boolean success = null;
		private String message = null;
		
		public ResultVo(){
		}
		
		public ResultVo(Boolean success, String message){
			this.success = success;
			this.message = message;
		}
		/***setter and getter***/
	}
}