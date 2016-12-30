-- drop database ims_system;
-- create database ims_system;
use ims_system;
/************************************/
/* 系统常量表 :存放各系统的常量参数
 * 属性配置方式，类似于java的属性文件
 */
/************************************/
drop table if exists configvalue;
create table configvalue(
	id int primary key auto_increment,
	environment_code varchar(20),
	config_code varchar(50),
	config_value varchar(255),
	valid_flag varchar(1) default '1',
	insert_time_for_his dateTime,
	operate_time_for_his dateTime
);
/************************************/
/* 
 * 用户表
 */
/************************************/
drop table if exists User;
create table user (
	id int primary key auto_increment,
	username varchar(20),				-- 用户名
	password varchar(32),				-- 密码
	salt int,							-- 盐值
	nickname varchar(50),				-- 昵称
	last_login_time datetime,			-- 上次登录时间
	error_input_times int,				-- 错误输入次数
	unfreeze_time datetime,				-- 解冻时间
	valid_flag varchar(1) default '1',
	insert_time_for_his dateTime,
	operate_time_for_his dateTime
);
/***********************/
-- 用户组表
/***********************/
DROP TABLE IF EXISTS userGroup;
CREATE TABLE userGroup(
	id INT PRIMARY KEY AUTO_INCREMENT,
	group_code varchar(30) unique,
	group_name VARCHAR(20),
	upper_group_code varchar(30) , -- 上级组代码 命名规则：【系统代码】_【组代码】,顶级用户组字段为null
	remark VARCHAR(50),
	system_code VARCHAR(30),
	valid_flag varchar(1) default '1',
	insert_time_for_his DATETIME,
	operate_time_for_his TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	unique key uk_groupCode_systemCode(group_code,system_code,valid_flag)	
);
/***********************/
-- 用户与用户组关系表
/***********************/
drop table if exists user_group_relation;
create table user_group_relation(
	id INT PRIMARY KEY AUTO_INCREMENT,
	user_id int ,
	group_id int,
	unique key uk_userId_groupId(user_id,group_id)
);













/***********************/
-- 菜单表
/***********************/
drop table if exists menu;
create table menu(
	id INT PRIMARY KEY AUTO_INCREMENT,  	-- 主键
	menu_name varchar(20) ,					-- 菜单名称
	menu_owner_permission_code varchar(30) ,-- 菜单归属权限代码
	menu_owner_system varchar(30),			-- 菜单所属系统代码
	valid_flag varchar(1) default '1',  	-- 有效标识
	insert_time_for_his dateTime,    		-- 插入时间
	operate_time_for_his dateTime			-- 更新时间
);


-- 初始化系统名称参数配置
insert into configvalue (environment_code,config_code,config_value,insert_time_for_his) values('SystemInfo','all.system.info','IMS|用户系统',CURRENT_TIMESTAMP);
insert into configvalue (environment_code,config_code,config_value,insert_time_for_his) values('SystemInfo','all.system.info','SSO|单点系统',CURRENT_TIMESTAMP);
insert into configvalue (environment_code,config_code,config_value,insert_time_for_his) values('SystemInfo','all.system.info','BLOG|博客系统',CURRENT_TIMESTAMP);
-- 添加用户
insert into 
user
(username,password,salt,nickname,insert_time_for_his) 
values
('czadxubin','1215xubin',33,'傲天下包',CURRENT_TIMESTAMP);

insert into 
user
(username,password,salt,nickname,insert_time_for_his) 
values
('czadxubin1','1215xubin',33,'傲天下包',CURRENT_TIMESTAMP);
-- 添加用户组
insert into 
usergroup
(system_code,group_code,upper_group_code,group_name,remark,insert_time_for_his)
values
('IMS','IMS_ADMIN',null,'用户系统管理员','用户用户系统所有权限',CURRENT_TIMESTAMP);
insert into 
usergroup
(system_code,group_code,upper_group_code,group_name,remark,insert_time_for_his)
values
('SSO','SSO_ADMIN',null,'单点系统管理员','用户单点系统所有权限',CURRENT_TIMESTAMP);
-- 用户与用户组关系
insert into user_group_relation (user_id,group_id) values((select id from user where username='czadxubin'),(select id from userGroup where group_Code='IMS_ADMIN'));
insert into user_group_relation (user_id,group_id) values((select id from user where username='czadxubin'),(select id from userGroup where group_Code='SSO_ADMIN'));
