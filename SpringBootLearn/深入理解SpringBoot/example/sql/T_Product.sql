/***��Ʒ��Ϣ��***/
create table T_Product(
	id						int(12)					not null auto_increment comment '���',
	product_name	varchar(60) 		not null comment '��Ʒ����',
	stock					decimal(16, 2)	not null comment '���',
	price					decimal(16, 2) 	not null comment '����',
	version				int(10)					not null default 0 comment '�汾��',
	note 					varchar(256) 		comment	'��ע',
	primary	key(id)
) engine=InnoDB charset=utf-8;