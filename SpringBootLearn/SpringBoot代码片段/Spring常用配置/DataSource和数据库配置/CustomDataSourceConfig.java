public CustomDataSourceConfig{
	@Bean 
	public JdbcTemplate jdbcTemplate(DataSource dataSource){
			return new JdbcTemplate(dataSource);
	}
	
	@Bean 
	public DataSource dataSource(){
		return new EmbeddedDatabaseBuilder()
						// Ƕ��ʽH2���ݿ⣬��Ϊ����Դ
						.setType(EmbeddedDatabaseType.H2)
						.addScripts('schema.sql', 'data.sql')
						.build();
	}
}