package com.springboot.chapter6.service.impl;

public class UserServiceImple implements UserService{
	@Autowired
	private UserDao userDao = null;
	
	// ��Ҫ�����������
	@Override
	@Transcational(isolation=Isolation.READ_COMMITTED, timeout=10)
	public int insertUser(User user){
		return userDao.insertUser(user);
	}
	
	// �����û�
	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED, timeout=10)
	public User getUserById(Long id){
		return userDao.getUserById(id);
	}
}