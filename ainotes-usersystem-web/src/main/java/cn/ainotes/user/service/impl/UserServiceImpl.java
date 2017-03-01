package cn.ainotes.user.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ainotes.core.service.impl.BaseServiceImpl;
import cn.ainotes.user.entity.User;
import cn.ainotes.user.mapper.UserMapper;
import cn.ainotes.user.service.facade.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
	@Autowired
	private UserMapper userMapper;

	@Override
	public User findUser(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUserByPK(Serializable id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}
}
