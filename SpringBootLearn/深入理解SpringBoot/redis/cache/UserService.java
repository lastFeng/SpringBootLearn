package com.springboot.redis.cache.service;

/***omit imports***/

public interface UserService{
	// ��ѯ�����û�
	User getUserById(Long id);
	
	// ����
	User insertUser(User user);
	
	// �޸�
	User updateUserName(Long id, String userName);
	
	// ��ѯ
	List<User> findUserListByUserNameAndnote(String userName, String note);
	
	// ɾ��
	int deleteUserById(Long id);
}