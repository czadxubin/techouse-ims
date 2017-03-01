package cn.ainotes.user.service.facade;

import java.io.Serializable;

import cn.ainotes.core.service.facade.BaseService;
import cn.ainotes.user.entity.User;

public interface UserService extends BaseService<User>{
	public User findUser(Serializable id);
	public void deleteUserByPK(Serializable id);
	public void addUser(User user);
	public void updateUser(User user);
}
