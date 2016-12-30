package cn.techouse.ims.user.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import cn.techouse.common.constants.SystemContants;
import cn.techouse.common.utils.CodecUtils;
import cn.techouse.ims.entity.User;
import cn.techouse.ims.entity.UserGroup;
import cn.techouse.ims.exception.UserIsExistedException;
import cn.techouse.ims.repositories.UserRepository;
import cn.techouse.ims.user.service.interf.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void registerUser(User user) {
		if(isExisted(user)){
			throw new UserIsExistedException("用户已存在");
		}
		user.setErrorInputTimes(0);
		user.setLastLoginTime(null);
		user.setUnfreezeTime(null);
		user.setValidFlag(SystemContants.DATA_VALID);
		try {
			CodecUtils.encodePwd(user);
		} catch (Exception e) {
			throw new RuntimeException("密码加密失败");
		}
		userRepository.save(user);
	}

	@Override
	public boolean isExisted(User user) {
		User queryUser = new User();
		queryUser.setUsername(user.getUsername());
		queryUser.setValidFlag(SystemContants.DATA_VALID);
		return userRepository.count(Example.of(queryUser))>0;
	}

	@Override
	public void deleteUsersByPKs(List<Serializable> pks) {
//		userRepository.deleteUsersByPks(pks);
	}

	@Override
	public void updateUser(User user) {
//		userRepository.saveAndFlush(user);
	}

	@Override
	public User findUserByUsername(User user) {
		user=userRepository.findUserByUsernameAndValidFlag(user.getUsername(),SystemContants.DATA_VALID);
		return user;
	}
	
	@Override
	public void saveUser(User user) {
		user.setValidFlag(SystemContants.DATA_VALID);
		userRepository.save(user);
	}

}
