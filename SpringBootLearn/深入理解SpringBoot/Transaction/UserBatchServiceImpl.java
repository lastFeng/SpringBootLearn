package com.springboot.chapter6.service.impl;

public class UserBatchServiceImpl implements UserBatchService{
	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED)
	public int insertUsers(List<User> userList){
		int count = 0;
		
		for(User user: userList){
			// �����ӷ�������ʹ��@Transactional����Ĵ�����Ϊ
			count += userService.insertUser(user);
		}
		return count;
	}
}