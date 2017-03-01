package cn.ainotes.user.mapper;

import java.io.Serializable;
import cn.ainotes.user.entity.User;

public interface UserMapper {
	public User findByPK(Serializable id);
	public void update(User user);
	public void deleteByPk(Serializable id);
	public void add(User user);
}
