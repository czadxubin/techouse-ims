USE ainotes_usersystem;
drop table  if exists users;
create table users(
	id int primary key auto_increment,	-- ����
	username varchar(20),				-- �û���
	password varchar(32),				-- ���룬md5
	nickname varchar(20)				-- �ǳ�
);