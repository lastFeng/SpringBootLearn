package com.springboot.chapter6.service;

/***omits imports***/

public interface UserService{
	// ��ȡ�û���Ϣ
	public User getUserById(Long id);
	
	// �����û�
	public int insertUser(User user);
}