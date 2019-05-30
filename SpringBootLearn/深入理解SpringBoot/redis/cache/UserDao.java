package com.springboot.redis.cache.dao;
/****omit imports***/

@Repository
public interface UserDao{
	// ��ȡ�����û�
	User getUserById(Long id);
	
	// �����û�
	int insertUser(User user);
	
	// �޸��û�
	int updateUser(User user);
	
	// ��ѯ�û���ָ��mybatis�Ĳ�������
	List<User> findUserListByUserNameAndnote(@Param("userName") String userName, @Param("note") String note);
	
	// ɾ���û�
	int deleteUserById(Long id);
}