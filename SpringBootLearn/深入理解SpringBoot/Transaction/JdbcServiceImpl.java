package com.springboot.chapter6.service.impl;

@Service
public class JdbcServiceImpl implements JdbcService{
		@Autowired
		private DataSource dataSource = null;
		
		@Override
		public int inserUser(String userName, String note){
			Connection conn = null;
			int result = 0;
			
			try{
					// ��ȡ����
					conn = dataSource.getConnection();
					// ��������
					conn.setAutoCommit(false);
					// ���ø���
					conn.setTransactionIsolation(TransactionIsolationLevel.READ_COMMITTED.getLevel());
					// ִ��SQL
					PreparedStatement ps = conn.preparedStatement("insert into t_user(user_name, note) values (?, ?)");
					
					// ����SQL����, �±��1��ʼ����
					ps.setString(1, userName);
					ps.setString(2, note);
					result = ps.executeUpdate();
					
					// �ύ����
					conn.commit();
				} catch(Exception e){
						// �ع�����
						if(conn != null){
							try{
								conn.rollback();
							} catch(SQLException el){
									el.printStackTrace();
								}
						}
						e.printStackTrace();
					} finally{
						try{
							if(conn != null && !conn.isClosed()){
								conn.close();
							}
						} catch(SQLException e){
							e.printStackTrace();
						}
					}
				return result;
		}		
}