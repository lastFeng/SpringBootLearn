package com.springboot.security.service.impl;

@Service
pubic class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private UserRoleService userRoleService;
	
	@Override
	@Transactiona
	public UserDetails loadUserByUserName(String userNmae) throws UsernameNotFoundException{
		// ��ȡ���ݿ��û���Ϣ
		DatabaseUser dbUser = userRoleService.getUserByUserName(userName);
		
		List<DatabaseRole> roleList = userRoleService.findRolesByUserName(userName);
		// ����Ϣת��ΪUserDetails
		return changeToUser(dbUser, roleList);
	}
	
	private UserDetails changeToUser(DatabaseUser dbUser, List<DatabaseRole> roleList){
		// Ȩ���б�
		List<GrantedAuthority> authorityList = new ArrayList<>()
		// �����ѯ���Ľ�ɫ
		for(DatabaseRole: roleList){
			GrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
			authorityList.add(authority);
		}
		// ����UserDetails���������û����������Ȩ��
		UserDetails userDetails = new User(dbUser.getUserName(), dbUser.getPwd(), authorityList);
		return userDetails;
	}
}