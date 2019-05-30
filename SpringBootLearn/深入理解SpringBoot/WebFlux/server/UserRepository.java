package com.springboot.webflux.repository;

@Repository
// ע�⣬������Ҫ�̳�ReactiveMongoRepository
public interface UserRepository extends ReactiveMongoRepository<User, Long>{
	/**
	* ���û����ͱ�ע����ģ����ѯ
	* @param userName �û�����
	* @param note ��ע
	* @return �����������û�
	*/
	public Flux<User> findByUserNameLikeAndNoteLike(String userName, String note);
}