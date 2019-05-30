/***�û���***/
create table t_user(
	id				int(12) not null auto_increment,
	user_name	varchar(60) not null,
	pwd				varchar(100) not null,
	/**�Ƿ���ã�1��ʾ���ã�0��ʾ������**/
	available	INT(1) default 1 check(available in(0,1)),
	note 			varchar(256),
	primary key(id),
	unique(user_name)
);