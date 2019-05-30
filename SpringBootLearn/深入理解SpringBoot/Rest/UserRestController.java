package com.springboot.redis.controller.usercontroller;

/*** omit imports ***/
@RestController
public class UserRestController{
	@Autowired
	private UserService userService;

	@PostMapping(value="/user/entity")
	public ResponseEntity<UserVo> insertUserEntity(@RequestBody UserVo userVo){
		User user = this.changeToPo(userVo);
		userService.insertUser(user);
		
		UserVo result = this.changeToVo(user);
		HttpHeaders headers = new HttpHeaders();
		
		String success = (result == null || result.getId() == null) ? "false" : "true";
		headers.add("success", success);
		
		return ResponseEnity<UserVo>(result, headers, HttpStatus.CREATED);
	}
	
	@PostMapping(value="/user/annotation")
	@ResponseStatus(HttpStatus.CREATED)
	public UserVo insertUserAnnotation(@RequestBody UserVo userVo){
		User user = this.changeToPo(userVo);
		userService.insertUser(user);
		UserVo result = this.changeToVo(user);
		return result;
	}
	
	@GetMapping(value="/user/exp/{id}" produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public UserVo getUserForExp(@PathVariable("id") Long id){
		User user = userService.getUser(id);
		
		// ����Ҳ����û������׳��쳣�����������֪ͨ
		if(user == null){
			throw new NotFoundException(1L, "�Ҳ����û���" + id + "����Ϣ");
		}
		UserVo userVo = this.changeToVo(user);
		return userVo;
	}
}