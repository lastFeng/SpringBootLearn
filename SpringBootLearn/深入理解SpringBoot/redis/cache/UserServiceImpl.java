package com.springboot.redis.cache.service.impl;

/***omit imports***/
/**
* ͨ������ע�����Redis��������
**/

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

		// ��ѯ�����û�
	@Override
	@Cacheable(value="redisCache", key="'redis_user_' + #id")
	public User getUserById(Long id){
		return userDao.getUserById(id);
	}
	
	// ����
	@Override
	@CachePut(value="redisCache", key="'redis_user_' + #result.id")
	public User insertUser(User user){
		userDao.insertUser(user);
		return user;
	}
	
	// �޸�
	@Override
	@CachePut(value="redisCache", condition="#result != 'null'", key="'redis_user_' + #id")
	public User updateUserName(Long id, String userName){
		User user = this.getUserById(id);
		if(user==null){
			return null;
		}
		user.setUserName(userName);
		userDao.updateUser
		return user;
	}
	
	// ��ѯ
	@Override
	List<User> findUserListByUserNameAndnote(String userName, String note){
		return userDao.findUserListByUserNameAndnote(userName, note);
	}
	
	// ɾ��
	@Override
	@CacheEvict(value="redisCache", key="'redis_user_' + #id", beforeInvocation=false)
	int deleteUserById(Long id){
		return userDao.deleteUserById(id);
	}
}