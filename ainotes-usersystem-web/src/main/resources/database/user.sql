USE ainotes_usersystem;
drop table  if exists users;
create table users(
	id int primary key auto_increment,	-- 主键
	username varchar(20),				-- 用户名
	password varchar(32),				-- 密码，md5
	nickname varchar(20)				-- 昵称
);