/***������Ϣ��***/
create table T_Purchase_Recode(
	id							int(12) 				not null auto_increment comment '���',
	user_id					int(12)					not null comment '�û����',
	product_id			int(12)					not null comment '��Ʒ���',
	price						decimal(16, 2)	not null comment '�۸�',
	quantity				int(12)					not null comment '����',
	sum							decimal(16, 2)  not null comment '�ܼ�',
	purchase_date		timestamp				not null default now() comment '��������',
	note						varchar(256)		comment '��ע',
	primary key(id)
)engine=InnDB charset=utf-8;